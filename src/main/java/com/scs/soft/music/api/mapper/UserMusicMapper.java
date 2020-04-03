package com.scs.soft.music.api.mapper;

import com.scs.soft.music.api.domain.entity.UserMusic;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;

/**
 * @author ZENG
 */
public interface UserMusicMapper {

    /**
     * 新增一条用户音乐
     * @param userMusic
     * @return
     * @throws SQLException
     */
    @Insert("INSERT INTO user_music (user_id,music_id) VALUE (#{userId},#{musicId}) ")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(UserMusic userMusic) throws SQLException;

    /**
     * 删除
     * @param userMusic
     * @return
     * @throws SQLException
     */
    @Delete("DELETE FROM user_music WHERE user_id=#{userId} AND music_id=#{musicId}")
    int delete(UserMusic userMusic) throws SQLException;

    /**
     * 查询
     * @param userMusic
     * @return
     * @throws SQLException
     */
    @Select("SELECT * FROM user_music WHERE user_id=#{userId} AND music_id=#{musicId}")
    UserMusic select(UserMusic userMusic) throws SQLException;
}