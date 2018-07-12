package com.yf.sys.manager;


import com.yf.common.entity.Page;
import com.yf.common.entity.Query;
import com.yf.sys.entity.SysLogEntity;

import java.util.List;

/**
 * 系统日志
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月14日 下午8:43:06
 */
public interface SysLogManager {

	void saveLog(SysLogEntity log);
	
	List<SysLogEntity> listLog(Page<SysLogEntity> page, Query query);
	
	int batchRemove(Long[] id);
	
	int batchRemoveAll();
	
}
