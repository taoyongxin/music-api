package com.scs.soft.music.api.controller;

import com.scs.soft.music.api.common.Result;
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
    @GetMapping(value = "/all")
    Result queryAll() {
        return musicService.queryAll();
    }

    @ApiOperation(value = "分页查询音乐信息", notes = "data为音乐数据")
    @GetMapping(value = "")
    Result queryByPage(@RequestParam("offset") int offset, @RequestParam("size") int size){
        return musicService.queryByPage(offset, size);
    }
    @ApiOperation(value = "更新", notes = "")
    @PostMapping(value = "/update")
    Result updateMusic(@RequestBody Music music) {
        return musicService.update(music);
    }

}
