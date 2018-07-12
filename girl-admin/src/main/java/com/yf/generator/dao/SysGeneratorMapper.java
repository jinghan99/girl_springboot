package com.yf.generator.dao;

import com.yf.common.entity.Page;
import com.yf.common.entity.Query;
import com.yf.generator.entity.ColumnEntity;
import com.yf.generator.entity.TableEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 代码生成器
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月28日 下午8:47:12
 */
@Mapper
public interface SysGeneratorMapper {

	List<TableEntity> listTable(Page<TableEntity> page, Query query);
	
	TableEntity getTableByName(String tableName);
	
	List<ColumnEntity> listColumn(String tableName);
	
}
