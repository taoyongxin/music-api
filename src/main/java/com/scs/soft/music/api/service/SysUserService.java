package com.scs.soft.music.api.service;

import com.scs.soft.music.api.common.Result;
import com.scs.soft.music.api.domain.dto.SignDto;

/**
 * @author Tao
 */
public interface SysUserService {
    /**
     * 通过用户id查询用户怇
     * @param id
     * @return
     */
    Result queryById(int id);

    /**
     * 用户注册帐号
     * @param signDto
     * @return
     */
    Result register(SignDto signDto);

    /**
     * 账号密码登录
     * @param signDto
     * @return
     */
    Result login(SignDto signDto);
}
