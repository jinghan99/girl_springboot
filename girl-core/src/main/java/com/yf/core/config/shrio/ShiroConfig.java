package com.yf.core.config.shrio;

import com.yf.core.config.Global;
import com.yf.core.config.redis.RedisCacheManager;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.session.mgt.AbstractSessionManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


/**
 * shiro配置项
 * @ClassName ShiroConfiguration
 * @Description
 * @Date 2018/5/3 10:27
 * @Author jinghan
 * @Version 1.0
 */
@Configuration
public class ShiroConfig {

    private static final Logger log = LoggerFactory.getLogger(ShiroConfig.class);




    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }


    @Bean(name = "sessionIdGenerator")
    public JavaUuidSessionIdGenerator sessionIdGenerator() {
        JavaUuidSessionIdGenerator sessionIdGenerator = new JavaUuidSessionIdGenerator();
        return sessionIdGenerator;
    }


    @Bean(name = "redisSessionDao")
    public RedisSessionDAO redisSessionDao() {
        RedisSessionDAO redisSessionDao = new RedisSessionDAO();
        redisSessionDao.setSessionIdGenerator(sessionIdGenerator());
        redisSessionDao.setActiveSessionsCacheName(Global.ACTIVE_SESSION_CACHE_PREFIXX);
        redisSessionDao.setCacheManager(redisCacheManager());
        return redisSessionDao;
    }

    @Bean(name = "redisCacheManager")
    public RedisCacheManager  redisCacheManager() {
        return new RedisCacheManager();
    }

    @Bean
    public ShiroRealm myShiroRealm(){
        ShiroRealm myShiroRealm = new ShiroRealm();
        return myShiroRealm;
    }





    @Bean(name = "sessionManager")
    public SessionManager sessionManager(SessionDAO sessionDAO){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        //设置session过期时间为3小时(单位：毫秒)，默认为30分钟
        sessionManager.setGlobalSessionTimeout(AbstractSessionManager.DEFAULT_GLOBAL_SESSION_TIMEOUT * 6);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        sessionManager.setSessionDAO(sessionDAO);
        sessionManager.setDeleteInvalidSessions(true);// 删除过期的session
        sessionManager.setCacheManager(redisCacheManager());

        //设置cookie httpOnly属性
        sessionManager.setSessionIdCookieEnabled(true);
        SimpleCookie simpleCookie = new SimpleCookie("sid");
        simpleCookie.setHttpOnly(true);
        sessionManager.setSessionIdCookie(simpleCookie);
        return sessionManager;
    }
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager securityManager( SessionManager sessionManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        // 使用redie 共享session
        securityManager.setSessionManager(sessionManager);
        // 注入缓存管理器;
        securityManager.setCacheManager(redisCacheManager());
        return securityManager;
    }
    @Bean
    public SimpleCookie rememberMeCookie() {
        // 这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie cookie = new SimpleCookie(Global.REMEMBER__ME);
        // cookie 生效时间 30 天，单位(秒)
        cookie.setMaxAge(30 * 24 * 60 * 60);
        return cookie;
    }

    @Bean
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        // 设置 rememberMe cookie 加密的密匙，默认AES算法 密钥长度(128 256 512 位)
        cookieRememberMeManager.setCipherKey(Base64.decode(Global.REMEMBER_ME_KEY));
        return cookieRememberMeManager;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    /**
     * ShiroFilterFactoryBean 处理拦截资源文件问题。
     * 注意：单独一个ShiroFilterFactoryBean配置是或报错的，因为在
     * 初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
     *
     Filter Chain定义说明
     1、一个URL可以配置多个Filter，使用逗号分隔
     2、当设置多个过滤器时，全部验证通过，才视为通过
     3、部分过滤器可指定参数，如perms，roles
     *
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 配置安全管理(必须)
//        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager());
        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");

        // 拦截器
        Map<String, String> map = new HashMap<>();
        //验证码 qiweb 2017年10月18日20:12:35
        map.put("/captcha**", "anon");
        map.put("/admin/**", "authc");
        map.put("/**", "anon");
        map.put("/logout", "logout");
        map.put("/login", "anon");
        //<!-- 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        //自定义加载权限资源关系
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        return shiroFilterFactoryBean;
    }

    /**
     * 异常拦截并跳转到对应的界面，在 BaseController 统一处理
     *
     * @return
     */
//    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
        Properties properties = new Properties();

        // key 为异常类，value 为直接对应的页面
        properties.setProperty("org.apache.shiro.authz.UnauthorizedException", "/common/error/403");
        simpleMappingExceptionResolver.setExceptionMappings(properties);
        return simpleMappingExceptionResolver;
    }
}
