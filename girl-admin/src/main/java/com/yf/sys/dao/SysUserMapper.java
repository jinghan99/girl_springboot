package com.yf.sys.dao;

import com.yf.common.entity.Query;
import com.yf.sys.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 系统用户dao
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月8日 下午3:26:05
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUserEntity> {

	SysUserEntity getByUserName(String username);
	
	List<Long> listAllMenuId(Long userId);
	
	List<Long> listAllOrgId(Long userId);
	
	int updatePswdByUser(Query query);
	
	int updateUserStatus(Query query);
	
	int updatePswd(SysUserEntity user);
	
}
