package com.yf.chrome.service.impl;

import com.yf.chrome.mapper.HomeBtEntityMapper;
import com.yf.chrome.model.HomeBtEntity;
import com.yf.chrome.model.HomeBtEntityExample;
import com.yf.chrome.service.HomeBtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jinghan
 * @title: HomeBtServiceImpl
 * @projectName girl-springboot
 * @description: bt 业务处理
 * @date 2020/9/24 17:59
 */

@Service
public class HomeBtServiceImpl implements HomeBtService {

    @Autowired
    private HomeBtEntityMapper homeBtEntityMapper;


    @Override
    public List<HomeBtEntity> all() {
        HomeBtEntityExample example = new HomeBtEntityExample();
        return homeBtEntityMapper.selectByExample(example);
    }
}
