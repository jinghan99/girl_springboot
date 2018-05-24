package com.yf.core.service.impl;

import com.yf.core.dao.sys.SysMenuMapper;
import com.yf.core.service.SysMenuService;
import com.yf.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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


    @Override
    public List<SysMenuMapper> getMenuList(Page page) {
        return sysMenuMapper.listPage(page);
    }
}
