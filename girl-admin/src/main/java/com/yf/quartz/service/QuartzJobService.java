package com.yf.quartz.service;


import com.yf.common.entity.Page;
import com.yf.common.entity.R;
import com.yf.quartz.entity.QuartzJobEntity;

import java.util.Map;

/**
 * 定时任务
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月20日 下午11:48:32
 */
public interface QuartzJobService {
	
	Page<QuartzJobEntity> list(Map<String, Object> params);
	
	R saveQuartzJob(QuartzJobEntity job);
	
	R getQuartzJobById(Long jobId);
	
	R updateQuartzJob(QuartzJobEntity job);
	
	R batchRemoveQuartzJob(Long[] id);
	
	R run(Long[] id);
	
	R pause(Long[] id);
	
	R resume(Long[] id);
	
}
