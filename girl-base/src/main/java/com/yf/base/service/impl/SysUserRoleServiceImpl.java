package com.yf.base.service.impl;

import com.yf.base.dao.SysUserRoleMapper;
import com.yf.base.service.SysUserRoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName SysUserRoleServiceImpl
 * @Description
 * @Date 2018/5/24 18:01
 * @Author jinghan
 * @Version 1.0
 */
@Transactional
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl implements SysUserRoleService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public Set<String> listUserRoles(String userId) {
        List<String> roles = sysUserRoleMapper.listUserRoles(userId);
        Set<String> rolesSet = new HashSet<>();
        for(String role : roles) {
            if(StringUtils.isNotBlank(role)) {
                rolesSet.addAll(Arrays.asList(role.trim().split(",")));
            }
        }
        return rolesSet;
    }
}
