package com.yf.sys.service.impl;

import com.yf.common.entity.Page;
import com.yf.common.entity.Query;
import com.yf.common.entity.R;
import com.yf.common.utils.CommonUtils;
import com.yf.sys.entity.SysRoleEntity;
import com.yf.sys.manager.SysRoleManager;
import com.yf.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 系统角色
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月12日 上午12:41:19
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleManager sysRoleManager;

	@Override
	public Page<SysRoleEntity> listRole(Map<String, Object> params) {
		Query query = new Query(params);
		Page<SysRoleEntity> page = new Page<>(query);
		sysRoleManager.listRole(page, query);
		return page;
	}

	@Override
	public R saveRole(SysRoleEntity role) {
		int count = sysRoleManager.saveRole(role);
		return CommonUtils.msg(count);
	}

	@Override
	public R getRoleById(Long id) {
		SysRoleEntity role = sysRoleManager.getRoleById(id);
		return CommonUtils.msg(role);
	}

	@Override
	public R updateRole(SysRoleEntity role) {
		int count = sysRoleManager.updateRole(role);
		return CommonUtils.msg(count);
	}

	@Override
	public R batchRemove(Long[] id) {
		int count = sysRoleManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

	@Override
	public R listRole() {
		List<SysRoleEntity> roleList = sysRoleManager.listRole();
		return CommonUtils.msgNotCheckNull(roleList);
	}

	@Override
	public R updateRoleOptAuthorization(SysRoleEntity role) {
		int count = sysRoleManager.updateRoleOptAuthorization(role);
		return CommonUtils.msg(count);
	}

	@Override
	public R updateRoleDataAuthorization(SysRoleEntity role) {
		int count = sysRoleManager.updateRoleDataAuthorization(role);
		return CommonUtils.msg(count);
	}
	
}
