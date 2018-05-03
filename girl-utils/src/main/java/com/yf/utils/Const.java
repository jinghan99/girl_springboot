package com.yf.utils;


/**
 * 项目名称：
 * @author:ljg
 * 
*/
public class Const {
    /**
     * 表示系统中执行请求后返回信息的状态类型
     */
    public enum MsgType {
        /**
         * 警告信息
         */
        WARN("warn"),
        /**
         * 成功信息
         */
        SUCCESS("success"),
        /**
         * 错误信息
         */
        ERROR("error");

        private String key = "";

        private MsgType(String key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return this.key;
        }
    }

    /**
     *@Description redis储存格式 字典转换 P_BM +
     *@Date 2018/3/12 16:02
     *@Author jinghan
     * key + id
     */
    public static final String REDIS_P_BM = "P_BM";
}
