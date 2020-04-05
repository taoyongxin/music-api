package com.scs.soft.music.api.service;

import com.scs.soft.music.api.MusicApiApplication;
import com.scs.soft.music.api.common.Result;
import com.scs.soft.music.api.domain.entity.UserMusic;
import com.scs.soft.music.api.mapper.CommonMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = MusicApiApplication.class)
class UserMusicServiceTest {

    @Resource
    private UserMusicService userMusicService;
    @Resource
    private CommonMapper commonMapper;
    @Test
    void getMusicByUserId() {
        Result mapList = userMusicService.getMusicByUserId(1);
        System.out.println(mapList);
    }

    @Test
    void batchInsertUserMusic() {
        try {
            commonMapper.alert("user_music");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<UserMusic> userMusicList = new ArrayList<>();
        for (int i=1;i<20;i++){
            UserMusic userMusic = UserMusic.builder()
                    .userId(1)
                    .musicId(i)
                    .build();
            userMusicList.add(userMusic);
        }
       Result result = userMusicService.batchInsertUserMusic(userMusicList);
        System.out.println(result);
    }
}