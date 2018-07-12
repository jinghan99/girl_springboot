package com.yf.base.controller.sys;

import com.yf.utils.BaseController;
import com.yf.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @ClassName LoginAdminController
 * @Description
 * @Date 2018/5/3 16:23
 * @Author jinghan
 * @Version 1.0
 */
@Controller
@RequestMapping("/sys")
public class LoginSysController extends BaseController{


    @Autowired
    private RedisUtils redisUtils;


}
