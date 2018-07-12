package com.yf.quartz.dao;

import com.yf.quartz.entity.QuartzJobEntity;
import com.yf.sys.dao.BaseMapper;
import org.apache.ibatis.annotations.Mapper;


/**
 * 定时任务
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月20日 下午11:19:55
 */
@Mapper
public interface QuartzJobMapper extends BaseMapper<QuartzJobEntity> {

}
