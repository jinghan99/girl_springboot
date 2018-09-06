package com.yfcloud.ribbonclient.controller;

import com.yfcloud.ribbonclient.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package com.yfcloud.ribbonclient.controller
 * @Description: TODO
 * @author: jingh
 * @date 2018/9/6 15:33
 */
@RestController
public class RibbonController {

    @Autowired
    private RibbonService ribbonService;

    @GetMapping("/hi")
    public String hi(@RequestParam(required = false,defaultValue = "defaultName") String name){
        return ribbonService.hi(name);
    }
}
