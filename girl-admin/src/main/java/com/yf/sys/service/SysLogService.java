package com.yf.sys.service;


import com.yf.common.entity.Page;
import com.yf.common.entity.R;
import com.yf.sys.entity.SysLogEntity;

import java.util.Map;

/**
 * 系统日志
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月14日 下午8:40:52
 */
public interface SysLogService {

	Page<SysLogEntity> listLog(Map<String, Object> params);
	
	R batchRemove(Long[] id);
	
	R batchRemoveAll();
	
}
