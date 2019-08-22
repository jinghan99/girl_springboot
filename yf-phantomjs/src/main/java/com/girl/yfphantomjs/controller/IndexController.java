package com.girl.yfphantomjs.controller;

import com.girl.yfphantomjs.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Package com.girl.yfphantomjs.controller
 * @Description: TODO
 * @author: jingh
 * @date 2019/8/19 21:19
 */
@Controller
public class IndexController {


    @Autowired
    private PageUtils pageUtils;

    @RequestMapping("index")
    public String index(String mobile) throws InterruptedException {
        pageUtils.mobile(mobile);
        return "ok";
    }
}
