package com.scs.soft.music.api.mapper;

import com.scs.soft.music.api.domain.entity.Music;
import org.apache.ibatis.annotations.*;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Zeng
 */
public interface MusicMapper {
    /**
     * 查询所有音乐
     * @return   List
     * @throws SQLException
     */
    @Select("SELECT * FROM t_music")
    List<Music> queryBy() throws SQLException;


    /**
     * 更新Music信息
     * @param music
     * @throws SQLException
     */
    @Update("UPDATE t_music SET name=#{name},author=#{author},img=#{img},count=#{count},type=#{type}" +
            "WHERE id=#{id}")
    void  update(Music music) throws SQLException;

    /**
     * 根据id查询音乐
     * @param id
     * @throws SQLException
     * @return Music
     */
    @Select("SELECT * FROM t_music WHERE id=#{id} ")
    Music queryById(Integer id) throws SQLException;

    /**
     * 分页查询音乐
     * @param offset
     * @param pageSize
     * @throws SQLException
     * @return List
     */
    @Select("SELECT * FROM t_music LIMIT #{offset},#{pageSize}")
    List<Music> queryByPage(@Param("offset") int offset, @Param("pageSize") int pageSize) throws SQLException;

    /**
     * 新增音乐
     * @param music
     * @throws SQLException
     */
    @Insert("INSERT INTO t_music (name,author,src,img,count,type,update_time)"+
            "VALUE (#{name},#{author},#{src},#{img},#{count},#{type},#{updateTime})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insert(Music music) throws SQLException;
}
