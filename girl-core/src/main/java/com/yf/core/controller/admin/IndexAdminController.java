package com.yf.core.controller.admin;

import com.yf.utils.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName IndexAdminController
 * @Description
 * @Date 2018/5/3 16:13
 * @Author jinghan
 * @Version 1.0
 */
@Controller
@RequestMapping(value = "/admin")
public class IndexAdminController extends BaseController {

    @RequestMapping(value = "",method = RequestMethod.GET)
    public ModelAndView hello(){
        ModelAndView mv = this.getModelAndView();
        mv.setViewName("index");
        return mv;
    }
}
