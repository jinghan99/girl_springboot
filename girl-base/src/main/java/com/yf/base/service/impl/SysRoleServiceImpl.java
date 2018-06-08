package com.yf.base.service.impl;

import com.yf.base.dao.SysRoleMapper;
import com.yf.base.service.SysRoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName SysRoleServiceImpl
 * @Description
 * @Date 2018/5/24 18:01
 * @Author jinghan
 * @Version 1.0
 */
@Transactional
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

}
