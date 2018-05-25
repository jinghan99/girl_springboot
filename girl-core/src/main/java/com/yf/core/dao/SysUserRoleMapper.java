package com.yf.core.dao;

import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@MapperScan
public interface SysUserRoleMapper extends BaseMapper<SysUserRoleMapper>{
    List listUserRoles(String userId);
}
