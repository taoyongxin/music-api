package com.scs.soft.music.api.mapper;

import com.scs.soft.music.api.domain.entity.UserMusic;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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

    /**
     * 通过musicId查用户
     * @param musicId
     * @return List
     * @throws SQLException
     */
    @Select("SELECT t1.*,t2.user_name,t3.* " +
            "FROM user_music t1 " +
            "LEFT JOIN sys_user t2 " +
            "ON t1.user_id = t2.id " +
            "LEFT JOIN t_music t3 " +
            "ON t1.music_id = t3.id " +
            "WHERE t1.music_id = #{musicId}")
    List<Map> selectUserMusicByMusicId(int musicId) throws SQLException;

    /**
     * 批量删除
     * @param userMusicList
     * @return
     * @throws SQLException
     */
    @Delete("<script>" +
            "DELETE FROM user_music WHERE " +
            "<foreach collection=\"list\" item=\"item\" index=\"index\" separator=\"or\"> " +
            "user_id=#{item.userId} " +
            "AND music_id=#{item.musicId} " +
            "</foreach>" +
            "</script>")
    int batchDelete(List<UserMusic> userMusicList) throws SQLException;
}
