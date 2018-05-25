package com.yf.core.service;

import java.util.Set;

public interface SysMenuService {
    /**
     *获取 用户权限
     *@Params: [userId]
     *@Date: 2018/5/24 17:41
     *@Author: jinghan
     */
    Set<String> listUserPerms(String userId);
}
