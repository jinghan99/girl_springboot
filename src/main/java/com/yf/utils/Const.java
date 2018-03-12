package com.yf.utils;

import org.springframework.context.ApplicationContext;

/**
 * 项目名称：
 * @author:ljg
 * 
*/
public class Const {
	public static final String COMMUNITY_ID = "1";
	public static final String COMMUNITY_NAME = "xhg";
	public static final String SESSION_SECURITY_CODE = "sessionSecCode";
	public static final String SESSION_MSG_CODE = "sessionMsgCode";         //短信验证码
	public static final String SESSION_PHONE = "sessionPhone";  //session手机号
	public static final String SESSION_USER = "sessionUser";		//后台管理员用户
	public static final String SESSION_APP_USER = "sessionAPPUser";//前台用戶
	public static final String SESSION_ROLE_RIGHTS = "sessionRoleRights";
	public static final String SESSION_menuList = "menuList";			//当前菜单
	public static final String SESSION_allmenuList = "allmenuList";		//全部菜单
	public static final String SESSION_QX = "QX";
	public static final String SESSION_userpds = "userpds";			
	public static final String SESSION_USERROL = "USERROL";				//用户对象
	public static final String SESSION_USERNAME = "username";			//用户名
	public static final String SESSION_PWD_TOKEN = "pwd_token";         //修改密码token
	public static final String TRUE = "T";
	public static final String FALSE = "F";
	public static final String LOGIN = "/admin/login_toLogin.do";				//登录地址
	public static final String SYSNAME = "admincfg/config/SYSNAME.txt";	//系统名称路径
	public static final String PAGE	= "admincfg/config/PAGE.txt";			//分页条数配置路径
	public static final String EMAIL = "admincfg/config/EMAIL.txt";		//邮箱服务器配置路径
	public static final String SMS1 = "admincfg/config/SMS1.txt";			//短信账户配置路径1
	public static final String SMS2 = "admincfg/config/SMS2.txt";			//短信账户配置路径2
	public static final String FWATERM = "admincfg/config/FWATERM.txt";	//文字水印配置路径
	public static final String IWATERM = "admincfg/config/IWATERM.txt";	//图片水印配置路径
	public static final String WEIXIN	= "admincfg/config/WEIXIN.txt";	//微信配置路径
	public static final String WEBSOCKET = "admincfg/config/WEBSOCKET.txt";//WEBSOCKET配置路径
	public static final String DISABLE_KEYWORD  = "admincfg/config/DISABLE_KEYWORD.txt";//敏感词配置
	public static final String FILEPATHIMG = "uploadFiles/uploadImgs/";	//图片上传路径
	public static final String FILEPATHFILE = "uploadFiles/file/";		//文件上传路径
	public static final String FILEPATHTWODIMENSIONCODE = "uploadFiles/twoDimensionCode/"; //二维码存放路径
	public static final String NO_INTERCEPTOR_PATH = ".*/((login)|(logout)|(code)|(app)|(weixin)|(static)|(main)|(websocket)).*";	//不对匹配该值的访问路径拦截（正则）
	public static final String PHONE = "phone";  //手机账号类型
	public static final String MAIL = "email";   //邮箱账号类型
	public static final int USER_LOCUS_DATE = 30*60;//获取任务轨迹     时间间隔 秒
	public static final String APPUSER_DEFULT_ROLEID = "a1717886a3244953928a483ac113f939";//注册普通用户 默认id
	/**
	 * 官方任务
	 */
	public static final String GF_TASKType = "rw0101"; 
	/**
	 * 用户任务
	 */
	public static final String YF_TASKType = "rw0102"; 
	
	
	public static ApplicationContext WEB_APP_CONTEXT = null; //该值会在web容器启动时由WebAppContextListener初始化
	
	/**
	 * APP Constants
	 */
	//app注册接口_请求协议参数)
	public static final String[] APP_REGISTERED_PARAM_ARRAY = new String[]{"countries","uname","passwd","title","full_name","company_name","countries_code","area_code","telephone","mobile"};
	public static final String[] APP_REGISTERED_VALUE_ARRAY = new String[]{"国籍","邮箱帐号","密码","称谓","名称","公司名称","国家编号","区号","电话","手机号"};
	
	//app根据用户名获取会员信息接口_请求协议中的参数
	public static final String[] APP_GETAPPUSER_PARAM_ARRAY = new String[]{"USERNAME"};
	public static final String[] APP_GETAPPUSER_VALUE_ARRAY = new String[]{"用户名"};
	
	//网易云信 app server key
    //创建用户
    public static final String NIM_CreateUrl = "https://api.netease.im/nimserver/user/create.action";
    //修改信息
    public static final String NIM_UpdateUrl = "https://api.netease.im/nimserver/user/update.action";
    //更新并获取新的token
    public static final String NIM_RefreshTokenUrl = "https://api.netease.im/nimserver/user/refreshToken.action";
    //应用app key
	public static final String NIM_AppKey = "7d899db7f9cf7842b2cbd3a03e679a72";
	
    public static final String NIM_AppSecret = "1f246164e01b";
	

	
}
