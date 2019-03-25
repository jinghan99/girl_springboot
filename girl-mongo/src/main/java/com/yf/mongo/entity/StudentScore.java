package com.yf.mongo.entity;

/**
 * @Package com.yf.mongo.entity
 * @Description: TODO
 * @author: jingh
 * @date 2019/3/25 11:41
 */
public class StudentScore {
    private String chinese;
    private String english;
    private String des;

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
