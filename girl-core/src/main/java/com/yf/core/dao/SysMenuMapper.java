package com.yf.core.dao;

import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * @ClassName SysMenuMapper
 * @Description
 * @Date 2018/5/22 16:32
 * @Author jinghan
 * @Version 1.0
 */
@MapperScan
public interface SysMenuMapper extends BaseMapper<SysMenuMapper>{
    List listUserPerms(String UserId);
}
