package com.yf.chrome.controller;

import com.yf.chrome.model.HomeBtEntity;
import com.yf.chrome.service.HomeBtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jinghan
 * @title: HomeBtController
 * @projectName girl-springboot
 * @description: bt 接口
 * @date 2020/9/24 17:54
 */
@RestController
@RequestMapping("/bt")
@Slf4j
public class HomeBtController {


    @Autowired
    private HomeBtService homeBtService;

    /**
     * 全部待 监听 接口
     * @return
     */
    @GetMapping("all")
    public List<HomeBtEntity> allBt() {
        return homeBtService.all();
    }
}
