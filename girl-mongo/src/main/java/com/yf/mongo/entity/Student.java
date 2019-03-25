package com.yf.mongo.entity;

/**
 * @Package com.yf.mongo.entity
 * @Description: TODO
 * @author: jingh
 * @date 2019/3/25 11:40
 */
public class Student {

    private String name;
    private String sex;
    private Integer age;
    private String des;
    private StudentScore studentScore;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public StudentScore getStudentScore() {
        return studentScore;
    }

    public void setStudentScore(StudentScore studentScore) {
        this.studentScore = studentScore;
    }
}
