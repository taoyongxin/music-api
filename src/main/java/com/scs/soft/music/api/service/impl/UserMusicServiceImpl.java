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
    public Result cancelMusic(int id) {
        try {
            userMusicMapper.deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
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
    public Result batchcancelMusic(String str) {
        String[] a = new String[100];
        int i, j, k = 0;
        String str1 = str;
        for (i = 0; str1.length() != 0; i++) {
            a[i] = str1.substring(0, str1.indexOf(","));
            k = str1.indexOf(",");
            str1 = str1.substring(k + 1, str1.length());
        }
        System.out.println(i);
        Integer[] b = new Integer[100];
        for (j = 0; j < i; j++) {
            b[j] = Integer.valueOf(a[j]);
            try {
                userMusicMapper.deleteById(b[j]);
            } catch (SQLException e) {
                return Result.failure(ResultCode.DATABASE_ERROR);
            }
        }
        return Result.success();
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

    @Override
    public Result batchInsertUserMusic(List<UserMusic> userMusics) {
        List<UserMusic> userMusicList = new ArrayList<>();
        for (int i =0;i<userMusics.size();i++){
            UserMusic userMusic = userMusics.get(i);
            UserMusic userMusic1 = null;
            try {
                userMusic1=userMusicMapper.select(userMusic);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (userMusic1==null){
                userMusicList.add(userMusics.get(i));
            }
        }
        try {
            userMusicMapper.batchInsert(userMusicList);
        } catch (SQLException e) {
            log.error(e.getMessage());
            return Result.failure(ResultCode.DATABASE_ERROR);
        }
        return Result.success();
    }
}
