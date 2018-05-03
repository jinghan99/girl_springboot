package com.yf.core.service.appuser;


import com.yf.core.dao.daoImpl.DaoSupport;
import com.yf.utils.PageData;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
@Service("appuserService")
public class AppuserService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	/**
	 *通过id获取数据
	 *@Params: [pd]
	 *@Date: 2018/4/27 9:31
	 *@Author: jinghan
     * unless = "#result==null" 当方法返回空值时，就不会被缓存起来。
	 */ 
    @Cacheable(value = "user", key = "#pd['user_id']", unless = "#result==null")
	public PageData findByUiId(PageData pd)throws Exception {
		return (PageData)dao.findForObject("AppuserMapper.findByUiId", pd);
	}
}

