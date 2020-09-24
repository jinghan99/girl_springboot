package com.yf.chrome.constant;

/**
 * @Package com.ympay.common.enumm
 * @Description: 库存 枚举类
 * @author: jinghan
 * @date 2019/5/15 13:55
 *
 */
public class HomeBtEnum {


    public enum BtType {

        BT51("51btbt"),

        BT31("31btbt"),
        ;
        private String code;

        private BtType(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

}
