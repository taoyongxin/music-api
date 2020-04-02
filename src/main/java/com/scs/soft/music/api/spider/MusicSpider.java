package com.scs.soft.music.api.spider;

import com.scs.soft.music.api.entity.Music;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MusicSpider {
    private static final Integer SUCCESS = 200;

    public static List<Music> getMusics(){
        List<Music> musics=new ArrayList<>();
        String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36";
        String url = "http://music.uixsj.cn/";
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            Thread.sleep(4000);
            HttpGet httpget  =new HttpGet(url);
            httpget.setHeader("User-Agent",userAgent);
            HttpClientContext context = HttpClientContext.create();
            CloseableHttpResponse response = httpclient.execute(httpget,context);
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println(statusCode);
        } catch (Exception e){
            e.printStackTrace();
        }
        return musics;
    }

    public static void main(String[] args) {
        getMusics();
    }
}
