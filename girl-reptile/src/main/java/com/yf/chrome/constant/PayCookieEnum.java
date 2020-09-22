package com.yf.chrome.constant;

/**
 * @Package com.ympay.common.enumm
 * @Description: 库存 枚举类
 * @author: jinghan
 * @date 2019/5/15 13:55
 *
 */
public class PayCookieEnum {



    /**
     * 登录 cookie 方式 自动
     */
    public static final String LOGIN_AUTO = "auto";

    /**
     * 登录 cookie 方式 手动
     */
    public static final String LOGIN_MANUAL = "manual";


    /**
     * 更新 cookie 方式
     */
    public static final String KEEP_TYPE_POST = "POST";


    public static final String KEEP_TYPE_PHANTOM = "PHANTOM";

    /**
     * cookie 类型
     */
    public enum CookieType {

        /**
         *  中国移动
         */
        CHINA_MOBILE("0"),

        /**
         *  中国联通
         */
        CHINA_UNICOM("1"),

        /**
         * 中国电信
         */
        CHINA_TELECOM("2");


        ;
        private String code;

        private CookieType(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    /**
     * cookie 可用状态
     */
    public enum cookieStatus {
        /**
         * 启用
         */
        ENABLE("0"),

        /**
         * 停用
         */
        DISABLE("1"),

        /**
         * 爬虫中
         */
        REPTILE("2"),

        ;
        private String code;

        private cookieStatus(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
    

    /**
     *  cookie 30 分钟 是否可用
     */
    public enum cookiePhoneTimeStatus {
        /**
         * 启用
         */
        ENABLE("0"),

        /**
         * 停用
         */
        Disable("1"),
        ;
        private String code;

        private cookiePhoneTimeStatus(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}
