package com.scs.soft.music.api.controller;

import com.scs.soft.music.api.common.Result;
import com.scs.soft.music.api.domain.dto.SignDto;
import com.scs.soft.music.api.service.SmsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Tao
 * @version 1.0
 * @ClassName UserLoginController
 * @Description TODO
 * @date 2020-04-02 10:50
 **/
@RestController
@RequestMapping(value = "/api/user")
@Api(value = "UserLoginController",tags = {"用户登录模块接口"})
public class UserLoginController {
    @Resource
    private SmsService smsService;

    /**
     * 发送手机短信
     * @param signDto
     * @return
     */
    @ApiOperation(value = "通过手机号码发送短信验证码",notes = "")
    @PostMapping(value = "/sms")
    Result getSms(@RequestBody SignDto signDto){
        return smsService.sendSms(signDto);
    }
}
