package com.yf.base.manager;


import com.yf.base.entity.SysAreaEntity;
import com.yf.common.entity.Query;

import java.util.List;

/**
 * 行政区域
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月18日 下午3:39:00
 */
public interface SysAreaManager {

	List<SysAreaEntity> listAreaByParentCode(Query query);
	
	int saveArea(SysAreaEntity area);
	
	SysAreaEntity getAreaById(Long areaId);
	
	int updateArea(SysAreaEntity area);
	
	int batchRemoveArea(Long[] id);
	
	boolean hasChildren(Long[] id);
	
}
