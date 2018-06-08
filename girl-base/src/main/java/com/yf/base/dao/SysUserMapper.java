package com.yf.base.dao;

import com.yf.base.entiy.SysUserEntity;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;


@MapperScan
public interface SysUserMapper extends BaseMapper<SysMenuMapper> {
    SysUserEntity getByUserName(String username);
    List<String> listUserPerms(String userId);
    List<String> listUserRoles(String userId);
}
