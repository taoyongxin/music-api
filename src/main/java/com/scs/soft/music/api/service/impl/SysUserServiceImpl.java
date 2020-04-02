package com.scs.soft.music.api.service.impl;

import com.scs.soft.music.api.common.Result;
import com.scs.soft.music.api.common.ResultCode;
import com.scs.soft.music.api.domain.dto.QueryDto;
import com.scs.soft.music.api.domain.dto.SignDto;
import com.scs.soft.music.api.domain.entity.SysUser;
import com.scs.soft.music.api.mapper.CommonMapper;
import com.scs.soft.music.api.mapper.SysUserMapper;
import com.scs.soft.music.api.service.RedisService;
import com.scs.soft.music.api.service.SysUserService;
import com.scs.soft.music.api.util.SaltUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * @author Tao
 * @version 1.0
 * @ClassName SysServiceImpl
 * @Description TODO
 * @date 2020-04-02 15:56
 **/
@Service
@Slf4j
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private CommonMapper commonMapper;
    @Resource
    private RedisService redisService;

    @Override
    public Result queryById(int id) {
        SysUser sysUser = null;
        try {
            sysUser = sysUserMapper.queryById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (sysUser != null){
            return Result.success(sysUser);
        } else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    @Override
    public Result register(SignDto signDto) {
        String mobile = signDto.getMobile();
        String password = signDto.getPassword();
        String passwordSalt = SaltUtil.MD5WithSalt(password,0);
        String salt = SaltUtil.getSaltFromHash(passwordSalt);
        QueryDto queryDto = QueryDto.builder().equalsString(mobile).build();
        SysUser sysUser;
        try {
            //查找数据库是否存在此手机号的用户
            sysUser = sysUserMapper.findUserBy(queryDto);
        } catch (SQLException e) {
            log.error(e.getMessage());
            return Result.failure(ResultCode.DATABASE_ERROR);
        }
        /*判断数据库中没有此手机号码 开始注册*/
        if(sysUser == null){
            SysUser sysUser1 = SysUser.builder()
                    .userName("User"+mobile)
                    .password(passwordSalt)
                    .salt(salt)
                    .phoneNumber(signDto.getMobile())
                    .status(1)
                    .binding(1)
                    .credits(0)
                    .createTime(LocalDate.now())
                    .build();
            try {
                commonMapper.alert("sys_user");
                sysUserMapper.insert(sysUser1);
            } catch (SQLException e) {
                log.error(e.getMessage());
                return Result.failure(ResultCode.DATABASE_ERROR);
            }
            String token = DigestUtils.sha3_256Hex(signDto.getMobile());
            redisService.set(mobile,token,60*24L);
            return Result.success(token);
        } else {
            return Result.failure(ResultCode.DATA_ALREADY_EXISTED);
        }
    }

    @Override
    public Result login(SignDto signDto) {
        String mobile = signDto.getMobile();
        String password = signDto.getPassword();
        SysUser sysUser;
        QueryDto queryDto = QueryDto.builder().equalsString(mobile).build();
        try {
            sysUser = sysUserMapper.findUserBy(queryDto);
        } catch (SQLException e) {
            log.error(e.getMessage());
            return Result.failure(ResultCode.DATABASE_ERROR);
        }
        if (sysUser != null) {
            /*判断用户帐号是否异常*/
            if(sysUser.getStatus()==1){
                /*密码正确*/
                if((SaltUtil.MD5WithSaltDeCode(password,sysUser.getSalt())).equals(sysUser.getPassword())){
                    String token = DigestUtils.sha3_256Hex(signDto.getMobile());
                    redisService.set(mobile, token, 60 * 24L);
                    SysUser sysUser1 = SysUser.builder()
                            .id(sysUser.getId())
                            .userName(sysUser.getUserName())
                            .email(sysUser.getEmail())
                            .phoneNumber(sysUser.getPhoneNumber())
                            .credits(sysUser.getCredits())
                            .createTime(sysUser.getCreateTime())
                            .lastLoginTime(sysUser.getLastLoginTime())
                            .build();
                    return Result.success(sysUser1);
                }
                return Result.failure(ResultCode.USER_PASSWORD_ERROR);
            }
           return Result.failure(ResultCode.USER_ACCOUNT_FORBIDDEN);
        }
        return Result.failure(ResultCode.USER_ACCOUNT_ERROR);
    }


}
