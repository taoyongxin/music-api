package com.scs.soft.music.api.domain.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author Tao
 * @version 1.0
 * @ClassName SysUser
 * @Description TODO
 * @date 2020-04-02 10:14
 **/
@Builder
@Data
public class SysUser {
    private Integer id;
    private String userName;
    private String password;
    private String salt;
    private String email;
    private String phoneNumber;
    private Integer status;
    private Integer binding;
    private Integer credits;
    private LocalDate createTime;
    private LocalDate lastLoginTime;
}
