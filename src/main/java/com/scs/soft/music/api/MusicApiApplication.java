package com.scs.soft.music.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.scs.soft.music.api.mapper")
public class MusicApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(MusicApiApplication.class, args);
    }

}
