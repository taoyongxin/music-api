package com.scs.soft.music.api.controller;

import com.scs.soft.music.api.common.Result;
import com.scs.soft.music.api.domain.dto.PageDto;
import com.scs.soft.music.api.domain.entity.Music;
import com.scs.soft.music.api.service.MusicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Zeng
 * @ClassName MusicController
 * @Description TOOD
 * @Date 2020/4/2
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/api/music")
@Api(value = "MusicController", tags = {"音乐模块接口"})
public class MusicController {
    @Resource
    private MusicService musicService;

    @ApiOperation(value = "通过id查询音乐信息", notes = "data为音乐数据")
    @GetMapping(value = "/{id}")
    Result queryById(@PathVariable int id) {
        return musicService.queryById(id);
    }

    @ApiOperation(value = "查询所有音乐信息", notes = "data为音乐数据")
    @GetMapping(value = "/allMusic")
    Result queryAll() {
        return musicService.queryAll();
    }

    @ApiOperation(value = "分页查询音乐信息", notes = "data为音乐数据")
    @GetMapping(value = "")
    Result queryByPage(@RequestParam("offset") int offset, @RequestParam("size") int size){
        return musicService.queryByPage(offset, size);
    }

    @ApiOperation(value = "更新", notes = "data为音乐数据")
    @PostMapping(value = "/update")
    Result updateMusic(@RequestBody Music music) {
        return musicService.update(music);
    }

    @ApiOperation(value = "模糊查询音乐信息", notes = "data为音乐数据")
    @GetMapping(value = "/search")
    Result searchByKeyword(@RequestParam("key") String key) {
        return musicService.queryByKeyword(key);
    }

    @ApiOperation(value = "分页查询音乐数据",notes = "音乐数据")
    @PostMapping(value = "/all")
    public Result getAllMusic(@RequestBody PageDto pageDto){ return musicService.getAllMusic(pageDto); }
}
