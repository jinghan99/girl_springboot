package com.yf.system.entiy.system;


/**
 * 类名称：User.java
 * 类描述：
 *
 * @author ljg
 * 作者单位：
 * 联系方式：
 * 创建时间：2014年6月28日
 * @version 1.0
 */
public class User {
    private String user_id;        //用户id
    private String username;    //用户名
    private String password;    //密码
    private String name;        //姓名
    private String rights;        //权限
    private String role_id;        //角色id
    private String last_login;    //最后登录时间
    private String ip;            //用户登录ip地址
    private String status;        //状态
    private Role role;            //角色对象
    private String skin;        //皮肤
    private String app_user_id; //关联用户id
    private String community_id;  //社区id


    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getLast_login() {
        return last_login;
    }

    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getApp_user_id() {
        return app_user_id;
    }

    public void setApp_user_id(String app_user_id) {
        this.app_user_id = app_user_id;
    }

    public String getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(String community_id) {
        this.community_id = community_id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }



}
