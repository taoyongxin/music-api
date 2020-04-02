package com.scs.soft.music.api.mapper;

import com.scs.soft.music.api.domain.entity.Music;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ZENG
 */
public interface MusicMapper {
    /**
     * 根据id查询音乐
     * @param id
     */
    void queryById(Integer id);

    /**
     * 分页查询音乐
     * @param offset
     * @param page
     * @return List
     */
    List<Music> queryByPage(int offset, int page);
}
