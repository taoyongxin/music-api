package com.scs.soft.music.api.service;

import com.scs.soft.music.api.MusicApiApplication;
import com.scs.soft.music.api.common.Result;
import com.scs.soft.music.api.domain.dto.SignDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = MusicApiApplication.class)
class SysUserServiceTest {

    @Resource
    private SysUserService sysUserService;
    @Test
    void queryById() {
        Result result = sysUserService.queryById(1);
        System.out.println(result);
    }

    @Test
    void register() {
        SignDto signDto = SignDto.builder()
                .mobile("13092037352")
                .password("000101")
                .build();
        sysUserService.register(signDto);
    }
}