package com.scs.soft.music.api.controller;

import com.scs.soft.music.api.common.Result;
import com.scs.soft.music.api.domain.entity.UserMusic;
import com.scs.soft.music.api.service.UserMusicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @ApiOperation(value = "用户取消收藏音乐",notes = "")
    @DeleteMapping("/cancelLike/{id}")
    Result deleteUserMusic(@PathVariable int id) {
        return userMusicService.cancelMusic(id);
    }

    @ApiOperation(value = "查喜欢这首歌曲的用户",notes = "")
    @GetMapping("/queryUser/{musicId}")
    Result queryUserMusicByMusicId(@PathVariable int musicId) {
        return userMusicService.queryByMusicId(musicId);
    }

    @ApiOperation(value = "用户批量取消收藏音乐",notes = "")
    @GetMapping("/batchCancelLike/{str}")
    Result batchDeleteUserMusic(@PathVariable String str) {
        return userMusicService.batchcancelMusic(str);
    }

    @ApiOperation(value = "查询用户收藏的音乐数据",notes = "音乐数据")
    @GetMapping("/{userId}")
    Result getMusicByUserId(@PathVariable int userId){
        return userMusicService.getMusicByUserId(userId);
    }

    @ApiOperation(value = "批量收藏音乐",notes = "音乐数据")
    @PostMapping("/batchInsertUserMusic")
    Result batchInsertUserMusic(@RequestBody List<UserMusic> userMusics){
        return userMusicService.batchInsertUserMusic(userMusics);
    }
}
