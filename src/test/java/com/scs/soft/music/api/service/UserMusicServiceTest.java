package com.scs.soft.music.api.service;

import com.scs.soft.music.api.MusicApiApplication;
import com.scs.soft.music.api.common.Result;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = MusicApiApplication.class)
class UserMusicServiceTest {

    @Resource
    private UserMusicService userMusicService;
    @Test
    void getMusicByUserId() {
        Result mapList = userMusicService.getMusicByUserId(1);
        System.out.println(mapList);
    }
}