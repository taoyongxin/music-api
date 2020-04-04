package com.scs.soft.music.api.service;

import com.scs.soft.music.api.MusicApiApplication;
import com.scs.soft.music.api.common.Result;
import com.scs.soft.music.api.domain.dto.PageDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = MusicApiApplication.class)
class MusicServiceTest {

    @Resource
    private MusicService musicService;
    @Test
    void getAllMusic() {
        PageDto pageDto = PageDto.builder()
                .currentPage(1)
                .pageSize(10)
                .build();
        Result result = musicService.getAllMusic(pageDto);
        System.out.println(result);
    }
}