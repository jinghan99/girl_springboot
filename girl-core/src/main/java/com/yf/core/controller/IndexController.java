package com.yf.core.controller;

import com.yf.core.service.appuser.AppuserService;
import com.yf.utils.BaseController;
import com.yf.utils.Page;
import com.yf.utils.PageData;
import com.yf.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class IndexController extends BaseController {

    @Resource(name="appuserService")
    private AppuserService appuserService;

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    @ResponseBody
    public String hello(){
        String str = "1111";
        return str;
    }
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView index(Page page){
        logBefore(logger, "首页");
        redisUtils.set("jinghan","value");
        ModelAndView mv = this.getModelAndView();
        mv.setViewName("index");
        return mv;
    }
}
