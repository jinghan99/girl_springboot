package com.yf.chrome.client;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author jinghan
 * @title: ChromeReptileClient
 * @projectName mobilepay
 * @description: chrome 爬虫
 * @date 2019/11/25 17:02
 */
public class ChromeReptileClient {

    private static String chromePath = "E:\\idea_workspace\\girl_springboot\\girl-reptile\\src\\main\\resources\\chromedriver.exe";


    private static final Logger logger = LoggerFactory.getLogger(ChromeReptileClient.class);


    public static void main(String[] args) {
        ChromeDriver chromeDriver = null;
        try {
            chromeDriver = getChromeDriver();
            String url = "http://51btbtt.com/thread-index-fid-950-tid-4555108.htm";
            List<String> hrefList = getDialogUrl(chromeDriver, url);
            for (String href : hrefList) {
                getBtDownLoadUrl(chromeDriver, href);
            }
        } finally {
            if (chromeDriver != null) {
                chromeDriver.close();
                chromeDriver.quit();
            }
        }
        chromeDriver.close();
        chromeDriver.quit();
    }

    /**
     * 获取 bt种子 下载链接
     *
     * @param chromeDriver
     * @param href
     */
    private static void getBtDownLoadUrl(ChromeDriver chromeDriver, String href) {
        chromeDriver.get(href);
        WebElement btUrlWebElement = chromeDriver.findElement(By.partialLinkText("本地下载"));
        String btUrl = btUrlWebElement.getAttribute("href");
        logger.info("bt种子 下载链接 {}", btUrl);
    }


    /**
     * 监听 bt 是否更新
     *
     * @param url
     */
    private static List<String> getDialogUrl(ChromeDriver chromeDriver, String url) {
        chromeDriver.get(url);
        List<WebElement> torrent = chromeDriver.findElements(By.partialLinkText("torrent"));
        if (ObjectUtil.isNotEmpty(torrent)) {
            return torrent.stream().map(v -> v.getAttribute("href")).collect(Collectors.toList());
        }
        return null;
    }


    private static ChromeDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", chromePath);

        Map<String, Object> prefs = new HashMap<String, Object>();
//        禁用 图片
        prefs.put("profile.managed_default_content_settings.images", 2);
        ChromeOptions chromeOptions = new ChromeOptions();
        //无头模式
        chromeOptions.setHeadless(false);
        chromeOptions.setExperimentalOption("prefs", prefs);
        ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);
        chromeDriver.manage().deleteAllCookies();
        return chromeDriver;
    }
}
