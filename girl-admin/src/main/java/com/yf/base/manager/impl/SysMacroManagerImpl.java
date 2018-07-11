package com.yf.base.manager.impl;

import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.base.dao.SysMacroMapper;
import net.chenlin.dp.modules.base.entity.SysMacroEntity;
import net.chenlin.dp.modules.base.manager.SysMacroManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 通用字典
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月15日 下午12:49:26
 */
@Component("sysMacroManager")
public class SysMacroManagerImpl implements SysMacroManager {

	@Autowired
	private SysMacroMapper sysMacroMapper;
	
	@Override
	public List<SysMacroEntity> listMacro() {
		return sysMacroMapper.list();
	}

	@Override
	public List<SysMacroEntity> listNotMacro() {
		return sysMacroMapper.listNotMacro();
	}

	@Override
	public int saveMacro(SysMacroEntity macro) {
		return sysMacroMapper.save(macro);
	}

	@Override
	public SysMacroEntity getObjectById(Long id) {
		return sysMacroMapper.getObjectById(id);
	}

	@Override
	public int updateMacro(SysMacroEntity macro) {
		return sysMacroMapper.update(macro);
	}

	@Override
	public int batchRemove(Long[] id) {
		return sysMacroMapper.batchRemove(id);
	}
	
	@Override
	public boolean hasChildren(Long[] id) {
		for(Long typeId : id) {
			int count = sysMacroMapper.countMacroChildren(typeId);
			if(CommonUtils.isIntThanZero(count)) {
				return true;
			}
		}
		return false;
	}

}
