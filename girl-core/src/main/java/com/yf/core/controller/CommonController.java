package com.yf.core.controller;

import com.yf.utils.AjaxMsg;
import com.yf.utils.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName CommonController
 * @Description
 * @Date 2018/6/4 9:26
 * @Author jinghan
 * @Version 1.0
 */
@Controller
@RequestMapping(value = "/common")
public class CommonController extends BaseController {

    @GetMapping(value =  "/error/403",produces = "application/json;charset=UTF-8")
    public String error403(HttpServletResponse response) {
        response.setStatus(403);
        return AjaxMsg.newError().addMessage("用户权限不够").toJson();
    }
}
