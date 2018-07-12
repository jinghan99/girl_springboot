package com.yf.quartz.dao;

import com.yf.quartz.entity.QuartzJobLogEntity;
import com.yf.sys.dao.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 定时任务日志
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月20日 下午11:04:51
 */
@Mapper
public interface QuartzJobLogMapper extends BaseMapper<QuartzJobLogEntity> {

	int batchRemoveAll();
	
}
