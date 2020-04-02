package com.scs.soft.music.api.domain.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

/**
 * @author Tao
 * @version 1.0
 * @ClassName SignDto
 * @Description TODO
 * @date 2020-04-02 10:22
 **/
@Data
@Builder
public class SignDto {
    @NonNull
    private String mobile;
    private String password;
    private String sms;
}
