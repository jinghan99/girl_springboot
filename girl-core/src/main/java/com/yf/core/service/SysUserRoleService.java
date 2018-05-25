package com.yf.core.service;

import java.util.Set;

/**
 * @ClassName SysUserRoleService
 * @Description
 * @Date 2018/5/24 17:56
 * @Author jinghan
 * @Version 1.0
 */
public interface SysUserRoleService {
    /**
     *获取用户角色
     *@Params: [userId]
     *@Date: 2018/5/24 17:41
     *@Author: jinghan
     */
    Set<String> listUserRoles(String userId);
}
