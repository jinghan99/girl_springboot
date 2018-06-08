package com.yf.base.config;

import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Configuration;
import java.io.File;
import java.util.Map;

/**全局配置类
 * @ClassName Global
 * @Description
 * @Date 2018/5/29 14:56
 * @Author jinghan
 * @Version 1.0
 */

@Configuration
public class Global {

    /**
     * 保存全局属性值
     */
    private static Map<String, String> map = Maps.newHashMap();
    /**
     * 属性文件加载对象
     */
    private static PropertiesLoader loader;

    /**
     * 显示/隐藏
     */
    public static final String SHOW = "1";
    public static final String HIDE = "0";

    /**
     * 是/否
     */
    public static final String YES = "1";
    public static final String NO = "0";

    /**
     * 对/错
     */
    public static final String TRUE = "true";
    public static final String FALSE = "false";

    /**
     * 默认消息key
     */
    public static final String DEFAULT_MESSAGE_PARAM = "message";

//    /**
//     * 用户缓存前缀
//     */
//    private static String REDIS_CACHE_PREFIX_USER_CACHE = "userCache:";


    /**
     * 记住我
     */
    public static String REMEMBER__ME = "rememberMe";

    /**
     * 记住我的加密密匙
     */
    public static String REMEMBER_ME_KEY = "DoHkenUvfszBE0/Z017AHw==";

    /**
     * Redis 中 Shiro 的统一前缀
     */
    public static String SHIRO_CACHE = "shiro-cache:";

    /**
     * 活动的 session 前缀
     */
    public static  String ACTIVE_SESSION_CACHE_PREFIXX = "shiro-activeSessionCache";


    /**
     * 获取菜单缓存的key
     *
     * @param key
     * @return
     */
    public static String userCachePrefixMenus(String key) {
        return userCachePrefix() + key + ":menus";
    }

    /**
     * 获取用户缓存的前缀
     * @return
     */
    public static String userCachePrefix() {

        return "userCache:";
    }

    static {
        System.out.println(System.getProperty("user.home") + File.separator + "application.properties");
        loader = new PropertiesLoader(System.getProperty("user.home") + File.separator + "application.properties");
//        loader = new PropertiesLoader("application.properties");
    }


    /**
     * 获取配置
     */
    public static String getConfig(String key) {
        String value = map.get(key);
        if (value == null) {
            value = loader.getProperty(key);
            map.put(key, value != null ? value : StringUtils.EMPTY);
        }
        return value;
    }


    /**
     * 获取 session 前缀
     */
    public static String getSessionPrefix() {
        return getConfig("redis.shiro.session.prefix");
    }

    /**
     * 获取 session 过期时间(秒)
     */
    public static long getSessionExpireTime() {
        return Long.parseLong(getConfig("redis.shiro.session.expireTime"));
    }

    /**
     * 获取 cache 前缀
     */
    public static String getCachePrefix() {
        return getConfig("redis.shiro.cache.prefix");
    }

    /**
     * 获取 cache 过期时间(秒)
     */
    public static long getCacheExpireTime() {
        return Long.parseLong(getConfig("redis.shiro.cache.expireTime"));
    }
}
