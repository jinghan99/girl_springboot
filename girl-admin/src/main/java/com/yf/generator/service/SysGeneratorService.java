package com.yf.generator.service;


import com.yf.common.entity.Page;
import com.yf.generator.entity.GeneratorParamEntity;
import com.yf.generator.entity.TableEntity;

import java.util.Map;

/**
 * 代码生成器
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月28日 下午8:55:29
 */
public interface SysGeneratorService {

	Page<TableEntity> listTable(Map<String, Object> params);
	
	byte[] generator(GeneratorParamEntity params);
	
}
