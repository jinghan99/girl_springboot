package com.yf.core.service;

import com.yf.core.dao.sys.SysMenuMapper;
import com.yf.utils.Page;

import java.util.List;

public interface SysMenuService {
    List<SysMenuMapper> getMenuList(Page page);
}
