package com.yf.core.service;

import com.yf.core.entiy.SysUserEntity;

import java.util.Set;

/**
 * @ClassName SysUserService
 * @Description
 * @Date 2018/5/24 17:21
 * @Author jinghan
 * @Version 1.0
 */
public interface SysUserService {
    /**
     *根据 用户名username 获取user
     *@Params: [name]
     *@Date: 2018/5/24 17:41
     *@Author: jinghan
     */ 
    SysUserEntity getByUserName(String name);
    /**
     *获取 用户权限
     *@Params: [userId]
     *@Date: 2018/5/24 17:41
     *@Author: jinghan
     */ 
    Set<String> listUserPerms(String userId);
    /**
     *获取用户角色
     *@Params: [userId]
     *@Date: 2018/5/24 17:41
     *@Author: jinghan
     */ 
    Set<String> listUserRoles(String userId);
}
