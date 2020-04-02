package com.scs.soft.music.api.service;

import com.scs.soft.music.api.domain.dto.SignDto;

import com.scs.soft.music.api.common.Result;

/**
 * @author Tao
 */
public interface SmsService {
    /**
     * 获取短信验证码
     * @param signDto
     * @return
     */
    Result sendSms(SignDto signDto);

    /**
     * 验证短信是否正确（signDto中有手机号和验证码）
     * @param signDto
     * @return
     */
    Result checkSms(SignDto signDto);


}