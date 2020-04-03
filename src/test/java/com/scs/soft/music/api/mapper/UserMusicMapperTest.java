package com.scs.soft.music.api.mapper;

import com.scs.soft.music.api.MusicApiApplication;
import com.scs.soft.music.api.domain.entity.UserMusic;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = MusicApiApplication.class)
class UserMusicMapperTest {

    @Resource
    private UserMusicMapper userMusicMapper;

    @Test
    void selectUserMusicByMusicId() {
        try {
            userMusicMapper.selectUserMusicByMusicId(1).forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void batchDelete() {
        List<UserMusic> userMusics = new ArrayList<>();
        UserMusic userMusic1 = UserMusic.builder()
                .musicId(7).userId(2).build();
        UserMusic userMusic2 = UserMusic.builder()
                .musicId(5).userId(3).build();
        userMusics.add(userMusic1);
        userMusics.add(userMusic2);
        int a = 0;
        try {
            a = userMusicMapper.batchDelete(userMusics);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(a);
    }
}