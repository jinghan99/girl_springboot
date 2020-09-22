package com.yf.chrome.constant;

import java.util.concurrent.TimeUnit;

/**
 * @author jinghan
 * @title: Constant
 * @projectName pay-v2
 * @description: 常量
 * @date 2019/8/1 10:12
 */
public class Constant {

    /**
     * 签名方式
     */
    public static final String SIGN_TYPE_MD5 = "MD5";

    /**
     * 统一下单
     */
    public static final String CREATE_GATEWAY="create";



    /**
     * 统一查询
     */
    public static final String QUERY_GATEWAY="query";

    /**
     * 默认延迟 延迟5
     */
    public static final int TIME_OUT = 5;

    /**
     * 默认延迟 延迟3
     */
    public static final int SMS_TIME_OUT = 5;


    /**
     * 支付等待时间 默认延迟 延迟60秒
     */
    public static final int PAY_TIME_OUT = 60 ;

    /**
     * 下单成功  默认通知 等待 2分钟
     */
    public static final int PAY_TIME_OUT_INIT = 120 ;

    /**
     * cookie 默认 暂停时效
     */
    public static final int PAY_COOKIE_TIME_OUT = 30 *60 * 1000 ;

    /**
     * 重试次数
     */
    public static final int MAX_ATTEMPTS = 4;


    /**
     *  话费重试次数
     */
    public static final int MOBILE_RETRY = 3;

    /**
     * redis 存储前缀 库存单号 二维码
     */
    public static final String REDIS_MOBILE_WAREHOUSE_PAY="REDIS_MOBILE_WAREHOUSE_PAY:";

    /**
     * redis 存储前缀 库存单号 移动上游单号
     */
    public static final String REDIS_MOBILE_WAREHOUSE_ORDER="REDIS_MOBILE_WAREHOUSE_ORDER:";

    /**
     * redis 存储前缀 库存单号 移动上游单号
     */
    public static final String REDIS_GATEWAY_ORDER="REDIS_GATEWAY_ORDER:";


    /**
     * redis 存储前缀 最后一次更新
     */
    public static final String REDIS_WAREHOUSE_UPDATE_ORDER="REDIS_GATEWAY_ORDER:";

    /**
     * redis  最小保持 开关
     */
    public static final String REDIS_KEEP_LOGIN="REDIS_KEEP_LOGIN:";


    /**
     * 收银台地址
     */
    public static final String GATE_URL = "/cashier/";

    /**
     * 支付宝 支付方式
     */
    public static final String ALI_PAY = "ALIPAY";


    /**
     * 微信 支付方式
     */
    public static final String WX_PAY = "WXPAY";


    /**
     * 更新 cookie 方式
     */
    public static final String KEEP_TYPE_POST = "POST";


    public static final String KEEP_TYPE_PHANTOM = "PHANTOM";


    public static void main(String[] args) {
        System.out.println( TimeUnit.SECONDS.toMillis(Constant.TIME_OUT));
    }
}
