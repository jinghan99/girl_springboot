package com.yf.security.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {
    private static String redisCode = "utf-8";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    /**
     *@Description  清空redis 所有数据
     *@Date 2018/4/24 16:13
     *@Author jinghan
     */
    public String deleteAllKey() {
        return (String) redisTemplate.execute(new RedisCallback() {
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                connection.flushDb();
                return "ok";
            }
        });
    }

    /**
     * 获取ZSet size
     *
     * @param key      缓存的键值
     */
    public Long getZSetSizeByKey(String key){
        // 获取已缓存的最近浏览的职位
        ZSetOperations<String, Object> zSetOperations = redisTemplate.opsForZSet();
        Long size = zSetOperations.size(key);
        return size;
    }

    /**ZSet
     * removeRangeByScore(K,Smin,Smax)：删除，键为K的集合，Smin<=score<=Smax的元素，返回删除个数
     * @return
     */
    public Long removeRangeByScore(String key, Double Smin , Double Smax){
        ZSetOperations<String, Object> zSetOperations = redisTemplate.opsForZSet();
        return zSetOperations.removeRangeByScore(key,Smin,Smax);
    }




    /**
     * 获取ZSet数据
     * 索引start<=index<=end的元素子集，倒序
     * @param key      缓存的键值
     * @return 缓存的对象
     */
    public List<Object> getCacheZSet(String key, Long start, Long end) {
        if (key == null) {
            return Collections.emptyList();
        }
        // 键为Key的集合，索引start<=index<=end的元素子集，倒序
        Set<Object> positionIds = redisTemplate.opsForZSet().reverseRange(key, start, end);
        return new ArrayList<>(positionIds);
    }
    /**
     * 获取ZSet数据
     * 键为K的集合，offerset和count是限制条件，从索引1开始找到count个元素=子集，从子集中找到Smin<=score<=Smax的元素集合，返回Set<V>，正序
     * @param key      缓存的键值
     * @return 缓存的对象
     */
    public List<Object> rangeByScore(String key, Long start, Long end) {
        if (key == null) {
            return Collections.emptyList();
        }
        // 键为Key的集合，索引start<=index<=end的元素子集，倒序
        Set<Object> positionIds = redisTemplate.opsForZSet().rangeByScore(key, start, end);
        return new ArrayList<>(positionIds);
    }

    /**
     *  Set Set<String>数据
     *
     * @param key      缓存的键值
     * @return 缓存的对象
     */
    public boolean  setSetString(String key, Set<String> dataSet){
        //先删除 历史数据
        try {
            if(exists(key)){
                del(key);
            }
            SetOperations<String, String> setOperations = stringRedisTemplate.opsForSet();
            if (dataSet == null) {
                Iterator<String> it = dataSet.iterator();
                while (it.hasNext()) {
                    String str = it.next();
                    setOperations.add(key, str);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    /**
     *  追加Set value 为String数据
     * @param key      缓存的键值
     * @return 缓存的对象
     */
    public boolean  addSetString(String key, String value){
        try {
            SetOperations<String, String> setOperations = stringRedisTemplate.opsForSet();
            if (value == null) {
                setOperations.add(key, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 获取Set<String>类型
     * @param key
     * @return
     */
    public Set<String> getSetString(String key){
        return  stringRedisTemplate.opsForSet().members(key);
    }

    /**
     * 缓存List数据
     *
     * @param key      缓存的键值
     * @param dataList 待缓存的List数据
     * @return 缓存的对象
     */
    public <T> ListOperations<String, T> setCacheList(String key, List<T> dataList) {
        //先删除 历史数据
        if(exists(key)){
            del(key);
        }
        //保存新数据
        ListOperations listOperation = redisTemplate.opsForList();
        if (null != dataList) {
            int size = dataList.size();
            for (int i = 0; i < size; i++) {
                listOperation.rightPush(key, dataList.get(i));
            }
        }
        return listOperation;
    }

    /**
     * 追加list数据
     *
     * @param key      缓存的键值
     * @param value 追加的List数据
     * @return 缓存的对象
     */
    public boolean addCacheList(String key, Object value){
        try {
            redisTemplate.opsForList().rightPush(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获得缓存的list对象
     *
     * @param key 缓存的键值
     * @return 缓存键值对应的数据
     */
    public List<Object> getCacheList(String key) {
        return redisTemplate.opsForList().range(key, 0, -1);
    }

    /**
     * @param
     */
    public long del(final String... keys) {
        return (Long) redisTemplate.execute(new RedisCallback() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                long result = 0;
                for (int i = 0; i < keys.length; i++) {
                    result = connection.del(keys[i].getBytes());
                }
                return result;
            }
        });
    }

    /**
     * @param key
     * @param value
     * @param liveTime
     */
    public void set(final byte[] key, final byte[] value, final long liveTime) {
        redisTemplate.execute(new RedisCallback() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                connection.set(key, value);
                if (liveTime > 0) {
                    connection.expire(key, liveTime);
                }
                return 1L;
            }
        });
    }

    /**
     * @param key
     * @param value
     * @param liveTime
     */
    public void set(String key, String value, long liveTime) {
        this.set(key.getBytes(), value.getBytes(), liveTime);
    }

    /**
     * @param key
     * @param value
     */
    public void set(String key, String value) {
        this.set(key, value, 0L);
    }

    /**
     * @param key
     * @param value
     */
    public void set(byte[] key, byte[] value) {
        this.set(key, value, 0L);
    }

    /**
     * @param key
     * @return
     */
    public String get(final String key) {
        return (String) redisTemplate.execute(new RedisCallback() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                try {
                    return new String(connection.get(key.getBytes()), redisCode);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                return "";
            }
        });
    }

    /**
     * @param key
     * @return
     */
    public boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }


    public void setStr(String key, String value){
        stringRedisTemplate.opsForValue().set(key, value);
    }

    /**
     * @param key
     * @param value
     * @param liveTime
     *
     *  TimeUnit.DAYS          //天
    TimeUnit.HOURS         //小时
    TimeUnit.MINUTES       //分钟
    TimeUnit.SECONDS       //秒
    TimeUnit.MILLISECONDS  //毫秒
     */
    public void setStr(String key, String value, long liveTime, TimeUnit timeUnit) {
        stringRedisTemplate.opsForValue().set(key, value, liveTime, timeUnit);
    }

    /**
     * @param key
     * @return
     */
    public String getStr(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * @param key
     * @return
     */
    public boolean existsStr(String key) {
        return stringRedisTemplate.hasKey(key);
    }

    /**
     * @param  keys
     */
    public long delStr(final String... keys) {
        return (Long) stringRedisTemplate.execute(new RedisCallback() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                long result = 0;
                for (int i = 0; i < keys.length; i++) {
                    result = connection.del(keys[i].getBytes());
                }
                return result;
            }
        });
    }


}