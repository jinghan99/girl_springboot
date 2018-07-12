package com.yf.base.manager;


import com.yf.base.entity.SysMacroEntity;

import java.util.List;


/**
 * 通用字典
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月15日 下午12:49:14
 */
public interface SysMacroManager {

	List<SysMacroEntity> listMacro();
	
	List<SysMacroEntity> listNotMacro();
	
	int saveMacro(SysMacroEntity macro);
	
	SysMacroEntity getObjectById(Long id);
	
	int updateMacro(SysMacroEntity macro);
	
	int batchRemove(Long[] id);
	
	boolean hasChildren(Long[] id);
	
}
