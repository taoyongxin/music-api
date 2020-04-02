package com.scs.soft.music.api.mapper;

import com.scs.soft.music.api.MusicApiApplication;
import com.scs.soft.music.api.domain.entity.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;

@SpringBootTest(classes = MusicApiApplication.class)
class SysUserMapperTest {

    @Resource
    private SysUserMapper sysUserMapper;

    @Test
    void queryById() throws SQLException {
        SysUser sysUser = sysUserMapper.queryById(1);
        System.out.println(sysUser);
    }
}