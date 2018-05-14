package com.yf.core.service.system;

import com.yf.core.dao.daoImpl.DaoSupport;
import com.yf.core.system.entiy.SysMenu;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName SysMenuService
 * @Description
 * @Date 2018/5/10 10:22
 * @Author jinghan
 * @Version 1.0
 */
@Transactional
@Service("sysMenuService")
public class SysMenuService {

    @Resource(name = "daoSupport")
    private DaoSupport dao;

    public List<SysMenu> getMenuList() throws Exception {
        return (List<SysMenu>) dao.findForList("SysMenuMapper.getMenuList",null);
    }
}
