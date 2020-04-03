package com.scs.soft.music.api.service;

import com.scs.soft.music.api.common.Result;
import com.scs.soft.music.api.domain.entity.UserMusic;

import java.util.List;

/**
 * @author ZENG
 */
public interface UserMusicService {

    /**
     * 用户收藏音乐
     * @param userMusic
     * @return
     */
    Result likeMusic(UserMusic userMusic);

    /**
     * 用户取消收藏音乐
     * @param userMusic
     * @return
     */
    Result cancelMusic(UserMusic userMusic);

    /**
     * 查看歌曲详情时，通过musicId查到喜欢这首歌曲的用户
     * @param musicId
     * @return
     */
    Result queryByMusicId(int musicId);

    /**
     * 批量取消收藏
     * @param userMusicList
     * @return
     */
    Result batchcancelMusic(List<UserMusic> userMusicList);
}
