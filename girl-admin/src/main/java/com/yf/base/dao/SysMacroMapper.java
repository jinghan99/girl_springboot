package com.yf.base.dao;

import net.chenlin.dp.modules.base.entity.SysMacroEntity;
import net.chenlin.dp.modules.sys.dao.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 通用字典
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月15日 下午12:46:31
 */
@Mapper
public interface SysMacroMapper extends BaseMapper<SysMacroEntity> {

	List<SysMacroEntity> listNotMacro();
	
	int countMacroChildren(Long typeId);
	
}
