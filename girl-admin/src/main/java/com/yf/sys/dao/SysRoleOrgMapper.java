package com.yf.sys.dao;

import net.chenlin.dp.modules.sys.entity.SysRoleOrgEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 角色与机构的关系
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月17日 上午11:29:43
 */
@Mapper
public interface SysRoleOrgMapper extends BaseMapper<SysRoleOrgEntity> {

	List<Long> listOrgId(Long roleId);
	
	int batchRemoveByOrgId(Long[] id);
	
	int batchRemoveByRoleId(Long[] id);
	
}
