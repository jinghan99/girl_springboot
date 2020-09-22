package com.yf.chrome.constant;

/**
 * @author jinghan
 * @title: NettyConstant
 * @projectName pay-v2
 * @description: netty 客户端 状态
 * @date 2019/9/2 16:16
 */
public class NettyConstant {


    /**
     * 标识
     */
    public static final String METHOD = "method";


    /**
     * netty  cookie登录 客户端 标识
     */
    public static final String METHOD_PHANTOMJS = "phantomjs";


    /**
     * cookie登录 客户端 队列
     */
    public enum PhantomjsQueue {

        /**
         * 发送短消息
         */
        SEND_SMS("send.sms"),


        /**
         * 创建 cookie
         */
        CREATE_COOKIE("create.cookie"),

        /**
         * 保持cookie 在线
         * 爬虫 PHANTOM
         */
        KEEP_COOKIE("keep.cookie"),




        ;
        private String code;

        private PhantomjsQueue(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}
