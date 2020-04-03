package com.scs.soft.music.api.mapper;

import com.scs.soft.music.api.MusicApiApplication;
import com.scs.soft.music.api.domain.entity.Music;
import com.scs.soft.music.api.spider.CloudMusicSpider;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest(classes = MusicApiApplication.class)
class MusicMapperTest {

    @Resource
    private MusicMapper musicMapper;

    @Test
    void queryById() {
        try {
            System.out.println(musicMapper.queryById(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void queryByPage() {
        try {
            musicMapper.queryByPage(0,5).forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//
    @Test
    void insert() throws Exception {
        List<Music> musicList = CloudMusicSpider.spider();
        for (Music music : musicList) {
            musicMapper.insert(music);
        }
    }
    @Test
    void queryByKeyword() {
        try {
            String key =  "流行" ;
            musicMapper.queryByKeyword(key).forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}