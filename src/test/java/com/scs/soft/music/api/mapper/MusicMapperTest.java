package com.scs.soft.music.api.mapper;

import com.scs.soft.music.api.MusicApiApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = MusicApiApplication.class)
class MusicMapperTest {

    @Resource
    private MusicMapper musicMapper;

    @Test
    void queryById() {
        System.out.println(musicMapper.queryById(1));
    }

    @Test
    void queryByPage() {
        musicMapper.queryByPage(0,5).forEach(System.out::println);
    }
}