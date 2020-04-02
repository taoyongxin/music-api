package com.scs.soft.music.api.service.impl;

import com.scs.soft.music.api.common.Result;
import com.scs.soft.music.api.common.ResultCode;
import com.scs.soft.music.api.domain.entity.SysUser;
import com.scs.soft.music.api.mapper.SysUserMapper;
import com.scs.soft.music.api.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * @author Tao
 * @version 1.0
 * @ClassName SysServiceImpl
 * @Description TODO
 * @date 2020-04-02 15:56
 **/
@Service
@Slf4j
public class SysServiceImpl implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

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
}
