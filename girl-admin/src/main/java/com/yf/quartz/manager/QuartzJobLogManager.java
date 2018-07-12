package com.yf.quartz.manager;


import com.yf.common.entity.Page;
import com.yf.common.entity.Query;
import com.yf.quartz.entity.QuartzJobLogEntity;

import java.util.List;

/**
 * 定时任务日志
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月20日 下午11:06:56
 */
public interface QuartzJobLogManager {

	List<QuartzJobLogEntity> listForPage(Page<QuartzJobLogEntity> page, Query query);
	
	int saveQuartzJobLog(QuartzJobLogEntity log);
	
	int batchRemove(Long[] id);
	
	int batchRemoveAll();
	
}
