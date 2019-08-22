package com.girl.yfphantomjs.utils;

import cn.edu.hfut.dmic.webcollector.model.Page;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.Set;

/**
 * @author handx 908716835@qq.com
 * @ClassName: PageUtils
 * @Description: PhantomJS工具类
 * @date 2017年6月1日 下午5:53:10
 */
@Component
public class PageUtils {

    @Value("${api.phantomjs_path}")
    private String phantomjs_path;

    private static final String DRIVER_PROPERTIES_PATH = "src/main/resources/config.properties";
    public static final  String PHANTOMJS_DRIVER_PATH  = "phantomjs.driver.path";
    public static final  String PHANTOMJS_JS           = "phantomjs.js";


    /**
     * 获取webcollector 自带htmlUnitDriver实例
     *
     * @param page
     * @param browserVersion 模拟浏览器
     * @return
     */
    public static HtmlUnitDriver getDriver(Page page, BrowserVersion browserVersion) {
        HtmlUnitDriver driver = new HtmlUnitDriver(browserVersion);
        driver.setJavascriptEnabled(true);
        driver.get(page.getUrl());
        return driver;
    }

    /**
     * 获取webcollector 自带 htmlUnitDriver实例(模拟默认浏览器)
     *
     * @return
     */
    public static HtmlUnitDriver getDriver(String url) {
        HtmlUnitDriver driver = new HtmlUnitDriver();
        driver.setJavascriptEnabled(true);
        driver.get(url);
        return driver;
    }


    /**
     * 获取PhantomJsDriver(可以爬取js动态生成的html)
     *
     * @param page
     * @return
     */
    public static WebDriver getWebDriver(Page page) {
        System.setProperty(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, PropertiesUtils.getInstance().get(PHANTOMJS_DRIVER_PATH));
        WebDriver driver = new PhantomJSDriver();
        driver.get(page.getUrl());
        return driver;
    }

    /**
     * @param @param  url
     * @param @return
     * @return WebDriver
     * @throws
     * @Title: getWebDriver
     * @Description: 根据url获取html
     */
    public static WebDriver getWebDriver(String url) {
        System.setProperty(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                PropertiesUtils.getInstance().get(PHANTOMJS_DRIVER_PATH));
        WebDriver driver = new PhantomJSDriver();
        driver.get(url);
        return driver;
    }


	public  void mobile(String phone) throws InterruptedException {

        String loginUrl = "https://login.10086.cn/html/login/touch.html";
		//设置必要参数
		DesiredCapabilities dcaps = new DesiredCapabilities();
		//ssl证书支持
		dcaps.setCapability("acceptSslCerts", true);
		//截屏支持
		dcaps.setCapability("takesScreenshot", true);
		//css搜索支持
		dcaps.setCapability("cssSelectorsEnabled", true);
		//js支持
		dcaps.setJavascriptEnabled(true);
		//驱动支持
		dcaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomjs_path);
		//创建无界面浏览器对象
		PhantomJSDriver driver = new PhantomJSDriver(dcaps);

        getSmsCode(loginUrl, phone, driver);

        loginMobile(driver);

        getCookie(driver);

        // 结束
        driver.close();
    }

    private static void loginMobile(PhantomJSDriver driver) throws InterruptedException {
        //        监听 控制台输入 验证码

        System.out.println("输入验证码: ");
        Scanner scanner = new Scanner(System.in);

        String smsCode = scanner.nextLine();

        System.out.println("验证码: "+smsCode);

        WebElement p_sms = driver.findElement(By.id("p_sms"));

        //2、填写验证码
        p_sms.sendKeys(smsCode);

        WebElement submit_bt = driver.findElement(By.id("submit_bt"));

        Thread.sleep(2000);

        //3 登录
        submit_bt.click();

        System.out.println(driver.getPageSource());
    }



    /**
     * 发送 短信验证
     * @param loginUrl
     * @param phone
     * @param driver
     * @throws InterruptedException
     */
    private static void getSmsCode(String loginUrl, String phone, PhantomJSDriver driver) throws InterruptedException {
        driver.get(loginUrl);

        Thread.sleep(5000L);

        System.out.println(driver.getPageSource());


        WebElement p_phone = driver.findElement(By.id("p_phone"));

        //1、填写手机号
        p_phone.sendKeys(phone);

        WebElement getSMSpwd = driver.findElement(By.id("getSMSpwd"));

        Thread.sleep(2000);

//		发送验证码
        getSMSpwd.click();
    }

    /**
     * 查看 cookie
     * @param driver
     * @throws InterruptedException
     */
    private static void getCookie(PhantomJSDriver driver) throws InterruptedException {
        //        查看是否 已有 cookie
        String rechargecredit = "https://touch.10086.cn/i/mobile/rechargecredit.html";
        driver.get(rechargecredit);

        Thread.sleep(5000L);


        driver.manage().getCookies();
        Cookie is_login = driver.manage().getCookieNamed("is_login");
        if(is_login == null){
            System.out.println("登录失败");
            Set<Cookie> cookies = driver.manage().getCookies();
            System.out.println("cookies："+cookies);
        }else{
            System.out.println("登录成功："+is_login);
            Set<Cookie> cookies = driver.manage().getCookies();
            System.out.println("cookies："+cookies);
        }
    }
}
