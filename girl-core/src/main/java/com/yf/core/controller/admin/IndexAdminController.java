package com.yf.core.controller.admin;

import com.yf.core.service.SysMenuService;
import com.yf.utils.BaseController;
import com.yf.utils.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

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

    @Resource(name = "sysMenuService")
    private SysMenuService sysMenuService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView hello(Page page){
        ModelAndView mv = this.getModelAndView();

        try {
            mv.addObject("menuList",sysMenuService.getMenuList(page));
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.setViewName("index");
        return mv;
    }
}
