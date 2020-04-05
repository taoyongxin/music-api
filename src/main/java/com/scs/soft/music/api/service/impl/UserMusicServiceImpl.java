package com.scs.soft.music.api.service.impl;

import com.scs.soft.music.api.common.Result;
import com.scs.soft.music.api.common.ResultCode;
import com.scs.soft.music.api.domain.entity.UserMusic;
import com.scs.soft.music.api.mapper.UserMusicMapper;
import com.scs.soft.music.api.service.UserMusicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        UserMusic userMusic1 = null;
        try {
            userMusic1 = userMusicMapper.select(userMusic);
        } catch (SQLException e) {
            log.error(e.getMessage());
            return Result.failure(ResultCode.DATABASE_ERROR);
        }
        if(userMusic1==null){
            try {
                userMusicMapper.insert(userMusic);
            } catch (SQLException e) {
                log.error(e.getMessage());
                return Result.failure(ResultCode.DATABASE_ERROR);
            }
        } else {
            return Result.failure(ResultCode.DATA_ALREADY_EXISTED);
        }
        return Result.success(userMusic);
    }

    @Override
    public Result cancelMusic(UserMusic userMusic) {
//        int row = 0;
//        try {
//            row = userMusicMapper.delete(userMusic);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        if (row == 1) {
//            return Result.success();
//        }
//        return Result.failure(ResultCode.DATA_IS_WRONG);
        UserMusic userMusic1 = null;
        try {
            userMusic1 = userMusicMapper.select(userMusic);
        } catch (SQLException e) {
            log.error(e.getMessage());
            return Result.failure(ResultCode.DATABASE_ERROR);
        }
        if (userMusic1!=null){
            try {
                userMusicMapper.delete(userMusic);
            } catch (SQLException e) {
                log.error(e.getMessage());
                return Result.failure(ResultCode.DATABASE_ERROR);
            }
        }else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
        return Result.success(ResultCode.SUCCESS);
    }

    @Override
    public Result queryByMusicId(int musicId) {
        List<Map> mapList = new ArrayList<>();
        try {
            mapList = userMusicMapper.selectUserMusicByMusicId(musicId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (mapList != null) {
            return Result.success(mapList);
        }
        return Result.failure(ResultCode.DATA_IS_WRONG);
    }

    @Override
    public Result batchcancelMusic(List<UserMusic> userMusicList) {
        int rows = 0;
        try {
           rows = userMusicMapper.batchDelete(userMusicList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (rows == userMusicList.size()) {
            return Result.success();
        }
        return Result.failure(ResultCode.DATA_IS_WRONG);
    }

    @Override
    public Result getMusicByUserId(int userId) {
        List<Map> mapList;
        try {
            mapList = userMusicMapper.getMusicByUserId(userId);
        } catch (SQLException e) {
            log.error(e.getMessage());
            return Result.failure(ResultCode.DATABASE_ERROR);
        }
        return Result.success(mapList);
    }
}
