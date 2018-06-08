package com.yf.base.service.impl;

import com.yf.base.dao.SysUserMapper;
import com.yf.base.entiy.SysUserEntity;
import com.yf.base.service.SysUserService;
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


}
