package com.scs.soft.music.api.domain.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author Tao
 * @version 1.0
 * @ClassName QueryDto
 * @Description 查询数据传输对象
 * @date 2020-04-02 16:24
 **/
@Data
@Builder
public class QueryDto {
    private Integer id;
    private String equalsString;
    private String keywords;
}
