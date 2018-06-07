package com.yf.base.controller.sys;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.yf.base.config.shrio.ShiroUtils;
import com.yf.base.entiy.R;
import com.yf.utils.BaseController;
import com.yf.utils.MD5Utils;
import com.yf.utils.RedisUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

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
