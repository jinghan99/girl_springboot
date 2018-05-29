package com.yf.core.config.shrio;

import com.yf.core.config.Global;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 *  redis实现共享session
 * @ClassName RedisSessionDAO
 * @Description
 * @Date 2018/5/3 10:56
 * @Author jinghan
 * @Version 1.0
 */
public class RedisSessionDAO extends EnterpriseCacheSessionDAO {

    private static Logger logger = LoggerFactory.getLogger(RedisSessionDAO.class);

    // session key 前缀
    private String sessionPrefix = "shiro-session:";
    // session 在 redis 过期时间是30分钟(1800秒)
    private int sessionExpireTime = 30;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 创建 session 保存到 redis 缓存
     *
     * @param session
     * @return
     */
    @Override
    protected Serializable doCreate(Session session) {
//        System.out.println("RedisSessionDao doCreate() ---------------------------->" + session.getId());
        Serializable sessionId = super.doCreate(session);
//        logger.debug("创建session:{}", session.getId());
        redisTemplate.opsForValue().set(sessionPrefix + sessionId, session);
        return sessionId;
    }

    /**
     * 获取 session
     *
     * @param sessionId
     * @return
     */
    @Override
    protected Session doReadSession(Serializable sessionId) {
//        System.out.println("RedisSessionDao doReadSession() ---------------------------->" + sessionId);
//        logger.debug("获取session:{}", sessionId);
        // 先从缓存中获取session，如果没有再去数据库中获取
        Session session = super.doReadSession(sessionId);
        if (null == session) {
            session = (Session) redisTemplate.opsForValue().get(sessionPrefix + sessionId);
        }
        return session;
    }

    /**
     * 更新 session 的最后一次访问时间
     *
     * @param session
     */
    @Override
    protected void doUpdate(Session session) {
//        System.out.println("RedisSessionDao doUpdate() ---------------------------->" + session.getId());
        super.doUpdate(session);
//        logger.debug("获取session:{}", session.getId());
        String key = sessionPrefix + session.getId();
        if (!redisTemplate.hasKey(key)) {
            redisTemplate.opsForValue().set(key, session);
        }
        // 设置过期时间(秒)
        redisTemplate.expire(key, sessionExpireTime, TimeUnit.SECONDS);

    }

    /**
     * 删除 session
     *
     * @param session
     */
    @Override
    protected void doDelete(Session session) {
//        System.out.println("RedisSessionDao doUpdate() ---------------------------->" + session.getId());
        logger.debug("删除session:{}", session.getId());
        super.doDelete(session);
        redisTemplate.delete(sessionPrefix + session.getId().toString());
    }

    @Override
    public Collection<Session> getActiveSessions() {
        Set<Session> sessions = new HashSet<>();

        Set<String> keys = redisTemplate.keys(Global.SHIRO_CACHE + Global.ACTIVE_SESSION_CACHE_PREFIXX + "*");
        if (keys != null && keys.size() > 0) {
            for (String key : keys) {
                Session s = (Session) redisTemplate.opsForValue().get(key);
                sessions.add(s);
            }
        }
        return sessions;
    }
}
