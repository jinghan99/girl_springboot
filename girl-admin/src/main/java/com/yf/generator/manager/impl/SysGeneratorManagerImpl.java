package com.yf.generator.manager.impl;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.modules.generator.dao.SysGeneratorMapper;
import net.chenlin.dp.modules.generator.entity.ColumnEntity;
import net.chenlin.dp.modules.generator.entity.TableEntity;
import net.chenlin.dp.modules.generator.manager.SysGeneratorManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 代码生成器
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月28日 下午8:54:44
 */
@Component("sysGeneratorManager")
public class SysGeneratorManagerImpl implements SysGeneratorManager {

	@Autowired
	private SysGeneratorMapper sysGeneratorMapper;
	
	@Override
	public void listTable(Page<TableEntity> page, Query query) {
		sysGeneratorMapper.listTable(page, query);
	}

	@Override
	public TableEntity getTableByName(String tableName) {
		return sysGeneratorMapper.getTableByName(tableName);
	}

	@Override
	public List<ColumnEntity> listColumn(String tableName) {
		return sysGeneratorMapper.listColumn(tableName);
	}

}
