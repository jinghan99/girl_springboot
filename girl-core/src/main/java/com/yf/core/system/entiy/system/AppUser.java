package com.yf.core.system.entiy.system;

import java.util.Date;

/**
 * 
* 类名称：User.java
* 类描述： 
* @author ljg
* 作者单位： 
* 联系方式：
* 创建时间：2014年6月28日
* @version 1.0
 */
public class AppUser {
	private String account; //账号id
	private String user_id;		//用户id
	private String username;	//用户名
	private String password; 	//密码
	private String usernick;    //用户昵称
	private int sex;            //用户性别
	private String name;		//姓名
	private String rights;		//权限
	private String role_id;		//角色id
	private String last_login;	//最后登录时间
	private String ip;			//用户登录ip地址
	private String status;		//状态
	private String bz;
	private String phone;       //用户手机 
	private String sfid;       // 
	private Date start_time;       //账户使用开始时间
	private Date end_time;       //账户使用结束时间
	private String headImgUrl;    //头像
	private String weixin_open_id;    //微信openid
	private int integral;        //积分
	private String community_id;  //社区id
	private int years;//年份 
	private String email;
	private String number;
	private int is_lawyer;//是否是律师  0不是    1是   
	private int if_audit;//是否审核通过
	
	
	public String getUsernick() {
		return usernick;
	}
	public void setUsernick(String usernick) {
		this.usernick = usernick;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getYears() {
		return years;
	}
	public void setYears(int years) {
		this.years = years;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
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
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSfid() {
		return sfid;
	}
	public void setSfid(String sfid) {
		this.sfid = sfid;
	}
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public String getHeadImgUrl() {
		return headImgUrl;
	}
	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}
	public String getWeixin_open_id() {
		return weixin_open_id;
	}
	public void setWeixin_open_id(String weixin_open_id) {
		this.weixin_open_id = weixin_open_id;
	}
	public int getIntegral() {
		return integral;
	}
	public void setIntegral(int integral) {
		this.integral = integral;
	}
	public String getCommunity_id() {
		return community_id;
	}
	public void setCommunity_id(String community_id) {
		this.community_id = community_id;
	}
	public int getIs_lawyer() {
		return is_lawyer;
	}
	public void setIs_lawyer(int is_lawyer) {
		this.is_lawyer = is_lawyer;
	}
	
	public int getIf_audit() {
		return if_audit;
	}
	public void setIf_audit(int if_audit) {
		this.if_audit = if_audit;
	}
	@Override
	public String toString() {
		return "AppUser [account=" + account + ", user_id=" + user_id + ", username=" + username + ", password="
				+ password + ", usernick=" + usernick + ", sex=" + sex + ", name=" + name + ", rights=" + rights
				+ ", role_id=" + role_id + ", last_login=" + last_login + ", ip=" + ip + ", status=" + status + ", bz="
				+ bz + ", phone=" + phone + ", sfid=" + sfid + ", start_time=" + start_time + ", end_time=" + end_time
				+ ", headImgUrl=" + headImgUrl + ", weixin_open_id=" + weixin_open_id + ", integral=" + integral
				+ ", community_id=" + community_id + ", years=" + years + ", email=" + email + ", number=" + number
				+ ", is_lawyer=" + is_lawyer + "]";
	}
	
}
