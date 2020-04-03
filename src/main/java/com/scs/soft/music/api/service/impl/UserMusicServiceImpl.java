package com.scs.soft.music.api.service.impl;

import com.scs.soft.music.api.common.Result;
import com.scs.soft.music.api.common.ResultCode;
import com.scs.soft.music.api.domain.entity.UserMusic;
import com.scs.soft.music.api.mapper.UserMusicMapper;
import com.scs.soft.music.api.service.UserMusicService;
import lombok.extern.slf4j.Slf4j;
import org.apache.regexp.RE;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * @author Zeng
 * @ClassName UserMusicServiceImpl
 * @Description TOOD
 * @Date 2020/4/3
 * @Version 1.0
 **/
@Service
@Slf4j
public class UserMusicServiceImpl implements UserMusicService {
    @Resource
    private UserMusicMapper userMusicMapper;

    @Override
    public Result likeMusic(UserMusic userMusic) {
        UserMusic userMusic1 = UserMusic.builder()
                .userId(userMusic.getUserId())
                .musicId(userMusic.getMusicId())
                .build();
        try {
            if (userMusicMapper.select(userMusic1) == null) {
                userMusicMapper.insert(userMusic1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Result.success(userMusic1);
    }

    @Override
    public Result cancelMusic(UserMusic userMusic) {
        int row = 0;
        try {
            row = userMusicMapper.delete(userMusic);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (row == 1) {
            return Result.success();
        }
        return Result.failure(ResultCode.DATA_IS_WRONG);
    }
}
