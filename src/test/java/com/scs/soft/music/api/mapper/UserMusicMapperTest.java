package com.scs.soft.music.api.mapper;

import com.scs.soft.music.api.MusicApiApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;

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
}