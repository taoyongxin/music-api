package com.scs.soft.music.api.service;

import com.scs.soft.music.api.common.Result;

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
}
