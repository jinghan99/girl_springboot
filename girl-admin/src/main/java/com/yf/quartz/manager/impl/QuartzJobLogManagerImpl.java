package com.yf.quartz.manager.impl;

import com.yf.common.entity.Page;
import com.yf.common.entity.Query;
import com.yf.quartz.dao.QuartzJobLogMapper;
import com.yf.quartz.entity.QuartzJobLogEntity;
import com.yf.quartz.manager.QuartzJobLogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 定时任务日志
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月20日 下午11:10:11
 */
@Component("quartzJobLogManager")
public class QuartzJobLogManagerImpl implements QuartzJobLogManager {

	@Autowired
	private QuartzJobLogMapper quartzLobLogMapper;
	
	@Override
	public List<QuartzJobLogEntity> listForPage(Page<QuartzJobLogEntity> page, Query query) {
		return quartzLobLogMapper.listForPage(page, query);
	}

	@Override
	public int saveQuartzJobLog(QuartzJobLogEntity log) {
		return quartzLobLogMapper.save(log);
	}

	@Override
	public int batchRemove(Long[] id) {
		return quartzLobLogMapper.batchRemove(id);
	}

	@Override
	public int batchRemoveAll() {
		return quartzLobLogMapper.batchRemoveAll();
	}

}
