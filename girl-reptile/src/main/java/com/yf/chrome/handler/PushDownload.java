package com.yf.chrome.handler;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import com.yf.chrome.scheduled.Bt51Scheduled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jinghan
 * @title: PushDownload
 * @projectName girl-springboot
 * @description: 推送下载地址
 * @date 2020/9/24 10:38
 */
public class PushDownload {

    public static String pushUrl = "http://local.yangfan.cloud:9091/api/url";

    private static final Logger logger = LoggerFactory.getLogger(PushDownload.class);

    public static void main(String[] args) {
        pushCloudTorrent("http://51btbtt.com/attach-download-fid-951-aid-5171780.htm");
    }


    /**
     * 推送至 CloudTorrent
     *
     * @param downLoadUrl
     */
    public static Boolean pushCloudTorrent(String downLoadUrl) {
        String body = HttpRequest.post(pushUrl)
                .header(Header.ACCEPT, "application/json, text/plain, */*")
                .header(Header.ACCEPT_ENCODING, "gzip, deflate")
                .header(Header.ACCEPT_LANGUAGE, "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6")
                .header(Header.HOST, "51btbtt.com")
                .header("Upgrade-Insecure-Requests", "1")
                .header(Header.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.102 Safari/537.36 Edg/85.0.564.51")
                .body(downLoadUrl)
                .execute()
                .body();
        logger.info("推送下载 downLoadUrl：{},响应：{}", downLoadUrl, body);
        if ("OK".equals(body)) {
            return true;
        } 
        return false;
    }
}
