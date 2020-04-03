package com.scs.soft.music.api.controller;

import com.scs.soft.music.api.common.Result;
import com.scs.soft.music.api.domain.entity.UserMusic;
import com.scs.soft.music.api.service.UserMusicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Zeng
 * @ClassName UserMusicController
 * @Description TOOD
 * @Date 2020/4/3
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/api/userMusic")
@Api(value = "UserMusicController",tags = {"用户音乐模块接口"})
public class UserMusicController {
    @Resource
    private UserMusicService userMusicService;

    @ApiOperation(value = "用户收藏音乐",notes = "")
    @PostMapping("/like")
    Result insertUserMusic(@RequestBody UserMusic userMusic) {
        return userMusicService.likeMusic(userMusic);
    }
}