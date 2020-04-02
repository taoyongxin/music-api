package com.scs.soft.music.api.service.impl;

import com.scs.soft.music.api.common.Result;
import com.scs.soft.music.api.common.ResultCode;
import com.scs.soft.music.api.domain.entity.Music;
import com.scs.soft.music.api.mapper.MusicMapper;
import com.scs.soft.music.api.service.MusicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Zeng
 * @ClassName MusicServiceImpl
 * @Description TOOD
 * @Date 2020/4/2
 * @Version 1.0
 **/
@Service
@Slf4j
public class MusicServiceImpl implements MusicService {
    @Resource
    private MusicMapper musicMapper;

    @Override
    public Result queryAll() {
        List<Music> musicList = null;
        try {
            musicList = musicMapper.queryBy();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (musicList.size() != 0) {
            return Result.success(musicList);
        } else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    @Override
    public Result queryById(Integer id) {
        Music music = null;
        try {
            music = musicMapper.queryById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (music != null) {
            return Result.success(music);
        } else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    @Override
    public Result queryByPage(int offset, int pageSize) {
        List<Music> musicList = null;
        try {
            musicList = musicMapper.queryByPage(offset, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (musicList.size() != 0) {
            return Result.success(musicList);
        } else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    @Override
    public Result update(Music music) {
       Music music1 = null;
        try {
            music1 = musicMapper.queryById(music.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assert music1 != null;
        if (!"".equals(music.getName())) {
            music1.setName(music.getName());
        }
        if (!"".equals(music.getImg())) {
            music1.setImg(music.getImg());
        }
        if (!"".equals(music.getAuthor())) {
            music1.setAuthor(music.getAuthor());
        }
        if (!"".equals(music.getType())) {
            music1.setType(music.getType());
        }
        if (!"".equals(music.getSrc())) {
            music1.setSrc(music.getSrc());
        }
        if (!"".equals(music.getCount())) {
            music1.setCount(music.getCount());
        }
        try {
            musicMapper.update(music1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Result.success(music1);
    }

    @Override
    public Result queryByKeyword(String key) {
        List<Music> musicList = null;
        try {
            musicList = musicMapper.queryByKeyword(key);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (musicList.size() != 0) {
            return Result.success(musicList);
        } else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }
}
