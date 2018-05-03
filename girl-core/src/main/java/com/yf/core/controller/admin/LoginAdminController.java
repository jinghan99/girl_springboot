package com.yf.core.controller.admin;

import com.yf.utils.AjaxMsg;
import com.yf.utils.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName LoginAdminController
 * @Description
 * @Date 2018/5/3 16:23
 * @Author jinghan
 * @Version 1.0
 */
@RestController
public class LoginAdminController extends BaseController{

    @GetMapping(value =  "/403.do",produces = "application/json;charset=UTF-8")
    public String error403(HttpServletResponse response) {
        response.setStatus(403);
        return AjaxMsg.newError().addMessage("用户权限不够").toJson();
    }
}
