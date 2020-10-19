package com.yf.chrome.handler;

import cn.hutool.core.text.UnicodeUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HtmlUtil;
import cn.hutool.http.HttpException;
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
public class Bt31Handler {


    public static final String HOST = "http://www.3btjia.com";

    private static final Logger logger = LoggerFactory.getLogger(Bt31Handler.class);


    public static void main(String[] args) {
//        List<String> btDownLoadHtml = find31BtDownLoadHtml("http://www.3btjia.com/thread-index-fid-10-tid-47985.htm");
        String btDownLoadUrl = get31BtDownLoadUrl("http://www.3btjia.com/attach-dialog-fid-10-aid-300093-ajax-1.htm");
//        System.out.println(btDownLoadUrl);
    }


    /**
     * 51btbtt 视频详情界面 获取下载界面
     *
     * @param url
     */
    public static List<String> find31BtDownLoadHtml(String url) {

        try {
            String html = HttpRequest.get(url)
                    .header(Header.ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                    .header(Header.ACCEPT_ENCODING, "gzip, deflate")
                    .header(Header.ACCEPT_LANGUAGE, "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6")
                    .header(Header.HOST, "www.3btjia.com")
                    .header(Header.REFERER, "http://www.3btjia.com/search-index.htm")
                    .header("Upgrade-Insecure-Requests", "1")
                    .header(Header.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.102 Safari/537.36 Edg/85.0.564.51")
                    .execute().body();
            String pattern = "<td>[\\s\\S]*?<a href=\"(.*?)\" class=\"ajaxdialog\" [\\s\\S]*?>[\\s\\S]*?</a>";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(html);
            List<String> download = new ArrayList<>();
            while (m.find()) {
                download.add(m.group(1));
            }
            logger.info("bt种子 获取下载界面 {}个", download.size());
            return download;
        } catch (HttpException e) {
            logger.info("bt种子 获取下载界面异常 {}", e.getLocalizedMessage(), e);
        }
        return null;
    }

    /**
     * 51btbtt 界面  下载地址
     *
     * @param downLoadHtml
     */
    public static String get31BtDownLoadUrl(String downLoadHtml) {
        String html = HttpRequest.get(downLoadHtml)
                .header(Header.ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                .header(Header.ACCEPT_ENCODING, "gzip, deflate")
                .header(Header.ACCEPT_LANGUAGE, "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6")
                .header(Header.HOST, "www.3btjia.com")
                .header("Upgrade-Insecure-Requests", "1")
                .header(Header.USER_AGENT, "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.102 Safari/537.36 Edg/85.0.564.51")
                .execute().body();
        html = UnicodeUtil.toString(html);
//        去除转义
        html = html.replace("\\", "");
        logger.info("bt种子 获取下载界面 html{}", html);
        String pattern = "<a href=\"(.*?)\" target=\"_blank\">";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(html);
        if (m.find()) {
            logger.info("bt种子 下载链接 {}", m.group(1));
            return m.group(1);
        }
        return null;
    }


}
