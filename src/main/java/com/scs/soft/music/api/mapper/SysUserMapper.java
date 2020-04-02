package com.scs.soft.music.api.mapper;

import com.scs.soft.music.api.domain.dto.QueryDto;
import com.scs.soft.music.api.domain.entity.SysUser;
import org.apache.ibatis.annotations.*;

import java.sql.SQLException;

/**
 * @author Tao
 * @version 1.0
 * @ClassName UserMapper
 * @Description TODO
 * @date 2020-04-02 11:29
 **/
public interface SysUserMapper {

    /**
     * 通过用户id查询用户数据
     * @param id
     * @return
     * @throws SQLException
     */
    @Select("SELECT * FROM sys_user WHERE id=#{id} ")
    SysUser queryById(@Param("id") int id) throws SQLException;

    /**
     * 新增用户
     * @param sysUser
     * @throws SQLException
     */
    @Insert("INSERT INTO sys_user (user_name,password,salt,email,phone_number,status,binding,credits,create_time,last_login_time)"+
            "VALUE (#{userName},#{password},#{salt},#{email},#{phoneNumber},#{status},#{binding},#{credits},#{createTime},#{lastLoginTime})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insert(SysUser sysUser) throws SQLException;

    /**
     * 修改用户数据
     * @param sysUser
     * @throws SQLException
     */
    @Update("UPDATE sys_user SET user_name=#{userName} WHERE id=#{id}")
    void update(SysUser sysUser) throws SQLException;


    /**
     * 根据id或者手机号码查找用户
     * @param queryDto
     * @return
     * @throws SQLException
     */
    @Select({"<script>",
            "SELECT * FROM sys_user ",
            "WHERE 1=1 ",
            "<when test='queryDto.id != null'> ",
            "AND id = #{queryDto.id} ",
            "</when> ",
            "<when test='queryDto.equalsString != null'> ",
            "AND phone_number = #{queryDto.equalsString} ",
            "</when> ",
            "</script>"})
    SysUser findUserBy(@Param("queryDto")QueryDto queryDto) throws SQLException;
}
