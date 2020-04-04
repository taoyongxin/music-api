package com.scs.soft.music.api.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Tao
 * @version 1.0
 * @ClassName LocalTest
 * @Description TODO
 * @date 2020-04-03 14:37
 **/
public class LocalTest {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date bt=null;
        Date et=null;
        try {
            bt = sdf.parse(null); // 登录时间
            et = sdf.parse("2020-04-03 00:00:00");  // 最后登录时间
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (bt.after(et)){
            System.out.println("bt大于et");
        }else{
            System.out.println("bt小于et");
        }
    }
}
