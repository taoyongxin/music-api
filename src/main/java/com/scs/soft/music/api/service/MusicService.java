package com.scs.soft.music.api.service;

import com.scs.soft.music.api.common.Result;
import com.scs.soft.music.api.domain.entity.Music;

/**
 * @author ZENG
 */
public interface MusicService {
    /**
     * 查询所有音乐
     * @return Result
     */
    Result queryAll();

    /**
     * 根据查询id查音乐
     * @param id
     * @return Result
     */
    Result queryById(Integer id);

    /**
     * 分页查询音乐
     * @param offset 偏移
     * @param pageSize
     * @return Result
     */
    Result queryByPage(int offset, int pageSize);

    /**
     * 更新音乐信息
     * @param music
     * @return
     */
    Result update(Music music);

    /**
     * 根据关键字查询歌曲
     * @param key
     * @return
     */
    Result queryByKeyword(String key);
}
