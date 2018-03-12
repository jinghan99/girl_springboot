package com.yf.system.entiy.system;

import java.util.Date;

/**
 * 类名称：MsgInfo.java
 * 类描述：
 *
 * @author ljg
 * 作者单位：
 * 联系方式：
 * 创建时间：2017年11月28日
 * @version 1.0
 */
public class MsgInfo {
    private String id;
    private String community_id; //社区id
    private String msg_title; //消息标题
    private String msg_content; //消息内容
    private Date create_time; //创建时间
    private String msg_type;  //消息类型

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(String community_id) {
        this.community_id = community_id;
    }

    public String getMsg_title() {
        return msg_title;
    }

    public void setMsg_title(String msg_title) {
        this.msg_title = msg_title;
    }

    public String getMsg_content() {
        return msg_content;
    }

    public void setMsg_content(String msg_content) {
        this.msg_content = msg_content;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getMsg_type() {
        return msg_type;
    }

    public void setMsg_type(String msg_type) {
        this.msg_type = msg_type;
    }


}
