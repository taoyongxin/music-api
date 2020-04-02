package com.scs.soft.music.api.controller;

import com.scs.soft.music.api.common.Result;
import com.scs.soft.music.api.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Tao
 * @version 1.0
 * @ClassName UserController
 * @Description TODO
 * @date 2020-04-02 16:01
 **/
@RestController
@RequestMapping(value = "/api/user")
@Api(value = "UserController",tags = {"用户模块接口"})
public class UserController {
    @Resource
    private SysUserService sysUserService;

    @ApiOperation(value = "通过用户id查询用户信息",notes = "data为用户数据")
    @GetMapping(value = "/{id}")
    Result queryById(@PathVariable int id) {
        return sysUserService.queryById(id);
    }

}
