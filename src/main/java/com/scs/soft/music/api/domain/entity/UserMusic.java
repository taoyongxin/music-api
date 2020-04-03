package com.scs.soft.music.api.domain.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author Zeng
 * @ClassName UserMusic
 * @Description 用户音乐
 * @Date 2020/4/3
 * @Version 1.0
 **/
@Data
@Builder
public class UserMusic {
    private Integer id;
    private Integer userId;
    private Integer musicId;
}
