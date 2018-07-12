package com.yf.sys.service;

import com.yf.common.entity.Page;
import com.yf.common.entity.R;
import com.yf.sys.entity.SysRoleEntity;

import java.util.Map;

/**
 * 系统角色
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月12日 上午12:40:42
 */
public interface SysRoleService {

	Page<SysRoleEntity> listRole(Map<String, Object> params);
	
	R saveRole(SysRoleEntity role);
	
	R getRoleById(Long id);
	
	R updateRole(SysRoleEntity role);
	
	R batchRemove(Long[] id);
	
	R listRole();
	
	R updateRoleOptAuthorization(SysRoleEntity role);
	
	R updateRoleDataAuthorization(SysRoleEntity role);
	
}
