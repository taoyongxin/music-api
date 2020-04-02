package com.scs.soft.music.api.util;

import java.util.Random;

/**
 * @author Tao
 * @version 1.0
 * @ClassName StringUtil
 * @Description TODO
 * @date 2020-04-02 10:03
 **/
public class StringUtil {
    private final static int LENGTH = 6;
    /**
     * 获取六位随机短信验证码
     * @return
     */
    public static String getVerifyCode(){
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0;i<LENGTH;i++){
            stringBuffer.append(random.nextInt(10));
        }
        return stringBuffer.toString();
    }
}
