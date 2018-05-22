package com.yf.core.service.system;

import com.yf.core.dao.SysMenuMapper;
import com.yf.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Cacheable(value = "SysMenuList", key = "#pd['user_id']", unless = "#result==null")
    public List<SysMenuMapper> getMenuList(Page page) throws Exception {
        return sysMenuMapper.listForPage(page);
    }
}
