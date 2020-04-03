package com.scs.soft.music.api.service;

import com.scs.soft.music.api.common.Result;
import com.scs.soft.music.api.domain.entity.UserMusic;

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
}
