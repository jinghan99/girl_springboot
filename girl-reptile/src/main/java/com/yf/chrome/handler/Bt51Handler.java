package com.yf.chrome.handler;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jinghan
 * @title: Bt51Hander
 * @projectName girl-springboot
 * @description: 爬虫处理机制
 * @date 2020/9/24 10:37
 */
public class Bt51Handler {


    public static final String HOST = "http://51btbtt.com/";

    private static final Logger logger = LoggerFactory.getLogger(Bt51Handler.class);


    public static void main(String[] args) {
        List<String> btDownLoadHtml = find51BtDownLoadHtml("http://51btbtt.com/thread-index-fid-981-tid-4558819.htm", 2);
//        String btDownLoadUrl = get51BtDownLoadUrl("http://51btbtt.com/attach-dialog-fid-1183-aid-5171735.htm");
//        System.out.println(btDownLoadUrl);
    }


    /**
     * 51btbtt 界面 获取下载界面
     *
     * @param url
     */
    public static List<String> find51BtDownLoadHtml(String url) {
        return find51BtDownLoadHtml(url, 0);
    }

    /**
     * @param url
     * @param attachIndex 定位楼层第几个
     * @return
     */
    public static List<String> find51BtDownLoadHtml(String url, Integer attachIndex) {
        if (ObjectUtil.isEmpty(attachIndex)) {
            attachIndex = 0;
        }
        String html = HttpRequest.get(url)
                .header(Header.ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                .header(Header.ACCEPT_ENCODING, "gzip, deflate")
                .header(Header.ACCEPT_LANGUAGE, "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6")
                .header(Header.HOST, "51btbtt.com")
                .header("Upgrade-Insecure-Requests", "1")
                .header(Header.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.102 Safari/537.36 Edg/85.0.564.51")
                .execute().body();
        // 先匹配楼层
        String attachListPattern = "<div class=\"attachlist\">[\\s\\S]*?</div>";
        Pattern r = Pattern.compile(attachListPattern);
        Matcher m = r.matcher(html);
        List<String> attachList = new ArrayList<>();
        while (m.find()) {
            attachList.add(m.group(0));
        }
        logger.info("bt种子 获取楼层 {}个", attachList.size());
        if (attachList.size() > attachIndex) {
            return regDownloadHtml(attachList.get(attachIndex));
        }
        return null;
    }

    /**
     * 正则匹配
     *
     * @param html
     * @return
     */
    private static List<String> regDownloadHtml(String html) {
        String pattern = "<td>[\\s\\S]*?<a href=\"(.*?)\" target=\"_blank\" rel=\"nofollow\">[\\s\\S]*?</a>";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(html);
        List<String> download = new ArrayList<>();
        while (m.find()) {
            download.add(HOST + m.group(1));
        }
        logger.info("bt种子 获取下载界面 {}个", download.size());
        return download;
    }


    /**
     * 51btbtt 界面  下载地址
     *
     * @param downLoadHtml
     */
    public static String get51BtDownLoadUrl(String downLoadHtml) {
        String html = HttpRequest.get(downLoadHtml)
                .header(Header.ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                .header(Header.ACCEPT_ENCODING, "gzip, deflate")
                .header(Header.ACCEPT_LANGUAGE, "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6")
                .header(Header.HOST, "51btbtt.com")
                .header("Upgrade-Insecure-Requests", "1")
                .header(Header.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.102 Safari/537.36 Edg/85.0.564.51")
                .execute().body();
        String pattern = "<dd><a href=\"(.*?)\" target=\"_blank\" style=\"float:left;\">";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(html);
        if (m.find()) {
            logger.info("bt种子 下载链接 {}", m.group(1));
            return HOST + m.group(1);
        }
        return null;
    }


}
