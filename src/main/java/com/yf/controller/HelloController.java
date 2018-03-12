package com.yf.controller;

import com.yf.controller.base.BaseController;
import com.yf.service.appuser.AppuserService;
import com.yf.utils.Const;
import com.yf.utils.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class HelloController extends BaseController {

    @Resource(name="appuserService")
    private AppuserService appuserService;

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    @ResponseBody
    public String hello(){
        String str = "1111";
        return str;
    }
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView index(){
        logBefore(logger, "首页");
//        #{account},
//			#{user_id},
//			#{username},
//			#{password},
//			#{name},
//			#{rights},
//			#{role_id},
//			#{last_login},
//			#{ip},
//			#{status},
//			#{bz},
//			#{phone},
//			#{sfid},
//			#{start_time},
//			#{end_time},
//			#{years},
//			#{email},
//			#{usernick},
//			#{sex},
//			#{weixin_open_id},
//			#{headImgUrl},
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();
        pd.put("community_id", Const.COMMUNITY_ID);
        pd.put("account","18048052202");
        pd.put("user_id",this.get32UUID());
        pd.put("username","jinghan");
        pd.put("account","12345");

        try {
            appuserService.saveU(pd);
            pd.put("account","16494334");
            mv.addObject("name1", appuserService.findByAC(pd));
        } catch (Exception e) {
            logger.error(e.toString(), e);
        }
        mv.setViewName("index");
        return mv;
    }
}
