package com.scs.soft.music.api.mapper;

import com.scs.soft.music.api.MusicApiApplication;
import com.scs.soft.music.api.domain.dto.QueryDto;
import com.scs.soft.music.api.domain.entity.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.time.LocalDate;

@SpringBootTest(classes = MusicApiApplication.class)
class SysUserMapperTest {

    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private CommonMapper commonMapper;

    @Test
    void queryById() throws SQLException {
        SysUser sysUser = sysUserMapper.queryById(1);
        System.out.println(sysUser);
    }

    @Test
    void insert() throws SQLException{
        commonMapper.alert("sys_user");
        SysUser sysUser = SysUser.builder()
                .userName("测试名字")
                .password("测试密码")
                .salt("kjbikbyfgvuuyj")
                .phoneNumber("17826012342")
                .status(1)
                .binding(0)
                .credits(0)
                .createTime(LocalDate.now())
                .build();
        sysUserMapper.insert(sysUser);
    }

    @Test
    void findUserBy() throws SQLException{
        QueryDto queryDto = QueryDto.builder()
                .equalsString("17826012341")
                .build();
        SysUser sysUser = sysUserMapper.findUserBy(queryDto);
        if (sysUser!=null){
            System.out.println(sysUser);
        }else {
            System.out.println("没找到");
        }

    }
}