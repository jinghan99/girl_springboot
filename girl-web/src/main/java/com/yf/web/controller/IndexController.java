package com.yf.web.controller;

import com.yf.core.service.appuser.AppuserService;
import com.yf.utils.Page;
import com.yf.utils.PageData;
import com.yf.web.controller.base.BaseController;
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

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    @ResponseBody
    public String hello(){
        String str = "1111";
        return str;
    }
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView index(Page page){
        logBefore(logger, "首页");
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();
        pd.put("account","18048052202");
        pd.put("user_id",this.get32UUID());
        pd.put("username","yf");
        pd.put("account","12345");
        try {
            appuserService.saveU(pd);
            pd.put("account","16494334");
            mv.addObject("name1", appuserService.listPdPageUser(page));
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        mv.setViewName("index");
        return mv;
    }
}
