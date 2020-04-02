package com.scs.soft.music.api.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Cao
 */
@Data
@Builder
public class Music {
    private Integer id;
    private String name;
    private String author;
    private String src;
    private String img;
    private String count;
    private String type;
    private LocalDateTime updateTime;
}
