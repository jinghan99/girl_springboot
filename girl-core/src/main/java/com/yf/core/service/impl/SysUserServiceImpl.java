package com.yf.core.service.impl;

import com.yf.core.dao.sys.SysUserMapper;
import com.yf.core.entiy.SysUserEntity;
import com.yf.core.service.SysUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName SysUserServiceImpl
 * @Description
 * @Date 2018/5/24 17:22
 * @Author jinghan
 * @Version 1.0
 */
@Transactional
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUserEntity getByUserName(String username) {
        return sysUserMapper.getByUserName(username);
    }

    @Override
    public Set<String> listUserPerms(String userId) {
        List<String> perms = sysUserMapper.listUserPerms(userId);
        Set<String> permsSet = new HashSet<>();
        for(String perm : perms) {
            if(StringUtils.isNotBlank(perm)) {
                permsSet.addAll(Arrays.asList(perm.trim().split(",")));
            }
        }
        return permsSet;
    }

    @Override
    public Set<String> listUserRoles(String userId) {
        List<String> roles = sysUserMapper.listUserRoles(userId);
        Set<String> rolesSet = new HashSet<>();
        for(String role : roles) {
            if(StringUtils.isNotBlank(role)) {
                rolesSet.addAll(Arrays.asList(role.trim().split(",")));
            }
        }
        return rolesSet;
    }
}
