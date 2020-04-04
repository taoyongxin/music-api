package com.scs.soft.music.api.spider;

import com.scs.soft.music.api.domain.entity.Music;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gjy
 * @version 1.0
 * @ClassName CloudMusicSpider
 * @Description TODO
 * @date 2020-04-03 9:52
 **/
public class CloudMusicSpider {
    private static final Integer SUCCESS = 200;



    public  static Document getCloudMusicList(String  url1 ){
        String userAgent = "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Mobile Safari/537.36";
        String url=url1;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            Thread.sleep(2000);
            HttpGet httpget  =new HttpGet(url);
            httpget.setHeader("User-Agent",userAgent);
            HttpClientContext context = HttpClientContext.create();
            CloseableHttpResponse response=null;
            try {
                 response = httpClient.execute(httpget,context);
            } catch (IOException e) {
                e.printStackTrace();
            }
            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode == SUCCESS){
                HttpEntity entity = response.getEntity();
                if(entity != null){
                    String res = null;
                    try {
                        res = EntityUtils.toString(entity);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Document document = Jsoup.parse(res);
//                    System.out.println(document);
                    return  document ;
                }
            }
//            System.out.println(response.getStatusLine().getStatusCode());

        } catch (InterruptedException e) {
            e.printStackTrace();

        }
       return  null ;
    }

    public  static List<Music> spider(){
        Document document = getCloudMusicList("https://music.163.com/m/discover/toplist");
//        System.out.println(document);
        List<Music> musicList = new ArrayList<>();
        Elements elements = document.getElementsByClass("m-sgitem");
//                    System.out.println("*************"+elements.size());
        for (Element element : elements){
            int id = Integer.parseInt(element.child(0).text());
            String href = element.attr("href");
            String photoUrl = "http:"+href ;
            System.out.println("url:"+photoUrl);
            Document document1 = getCloudMusicList( photoUrl);
            Elements elements1 = document1.getElementsByClass("u-img");
            String img = elements1.attr("src");
//            System.out.println("img :"+ img);
//            System.out.println("********************************************************************");
            String[] strs = href.split("=");
            String src =null;
            for (int a = 1; a<strs.length;a+=2){
                src = "http://music.163.com/song/media/outer/url?id="+strs[a]+".mp3";
            }
            Element sgftEle = element.child(1);
            Element sgchfl = sgftEle.child(0);
            String name = sgchfl.child(0).text();
            String authorMusic = sgchfl.child(1).text();
//                        System.out.println(authorMusic);
            Music music = Music.builder()
                    .id(id)
                    .name(name)
                    .author(authorMusic)
                    .src(src)
                    .img(img)
                    .count(0)
                    .type("流行")
                    .updateTime(LocalDateTime.now())
                    .build();
            musicList.add(music);
        }
        return  musicList ;
    }
    public static void main(String[] args) throws Exception {
        spider();
    }


}
