package com.scs.soft.music.api.mapper;

import com.scs.soft.music.api.domain.entity.Music;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Zeng
 */
public interface MusicMapper {
    /**
     * 查询所有音乐
     * @return
     */
    @Select("SELECT * FROM t_music")
    List<Music> queryBy();


    /**
     * 更新Music信息
     * @param music
     */
    @Update("UPDATE t_music SET name=#{name},author=#{author},img=#{img},count=#{count},type=#{type}")
    void  update(Music music);

    /**
     * 根据id查询音乐
     * @param id
     * @return Music
     */
    @Select("SELECT * FROM t_music WHERE id=#{id} ")
    Music queryById(Integer id);

    /**
     * 分页查询音乐
     * @param offset
     * @param pageSize
     * @return List
     */
    @Select("SELECT * FROM t_music LIMIT #{offset},#{pageSize}")
    List<Music> queryByPage(@Param("offset") int offset, @Param("pageSize") int pageSize);
}
