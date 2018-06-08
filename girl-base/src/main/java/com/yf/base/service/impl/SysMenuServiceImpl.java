package com.yf.base.service.impl;

import com.yf.base.dao.SysMenuMapper;
import com.yf.base.service.SysMenuService;
import com.yf.utils.Page;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @ClassName SysMenuServiceImpl
 * @Description
 * @Date 2018/5/10 10:22
 * @Author jinghan
 * @Version 1.0
 */
@Transactional
@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    /**
     *获取用户权限
     *@Params: [userId]
     *@Date: 2018/5/25 9:43
     *@Author: jinghan
     */
    @Override
    public Set<String> listUserPerms(String userId) {
        List<String> perms = sysMenuMapper.listUserPerms(userId);
        Set<String> permsSet = new HashSet<>();
        for(String perm : perms) {
            if(StringUtils.isNotBlank(perm)) {
                permsSet.addAll(Arrays.asList(perm.trim().split(",")));
            }
        }
        return permsSet;
    }
}
