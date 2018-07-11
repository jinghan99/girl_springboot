package com.yf.base.dao;

import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.base.entity.SysAreaEntity;
import net.chenlin.dp.modules.sys.dao.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 行政区域
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月18日 下午3:36:04
 */
@Mapper
public interface SysAreaMapper extends BaseMapper<SysAreaEntity> {

	List<SysAreaEntity> listAreaByParentCode(Query query);
	
	int countAreaChildren(Long areaId);
	
}
