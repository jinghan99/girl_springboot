package com.yf.chrome.utils.vo;

/**
 * @author jinghan
 * @title: BtNewInfoVo
 * @projectName girl-springboot
 * @description: bt 最新的信息
 * @date 2020/10/13 9:24
 */
public class BtNewInfoVo {

    public BtNewInfoVo(String btName, String btUrl) {
        this.btName = btName;
        this.btUrl = btUrl;
    }

    private String btName;

    private String btUrl;

    public String getBtName() {
        return btName;
    }

    public void setBtName(String btName) {
        this.btName = btName;
    }

    public String getBtUrl() {
        return btUrl;
    }

    public void setBtUrl(String btUrl) {
        this.btUrl = btUrl;
    }

    @Override
    public String toString() {
        return "BtNewInfoVo{" +
                "btName='" + btName + '\'' +
                ", btUrl='" + btUrl + '\'' +
                '}';
    }
}
