package com.scs.soft.music.api.mapper;

import com.scs.soft.music.api.domain.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
}
