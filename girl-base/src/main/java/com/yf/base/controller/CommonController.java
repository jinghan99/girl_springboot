package com.yf.base.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.yf.base.config.shrio.ShiroUtils;
import com.yf.utils.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @ClassName 常用Controller
 * @Description
 * @Date 2018/6/4 9:26
 * @Author jinghan
 * @Version 1.0
 */
@Controller
@RequestMapping(value = "/common")
public class CommonController extends BaseController {

    @Autowired
    private Producer producer;

    /**
     * 验证码
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/captcha.jpg")
    public void captcha(HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        //保存到shiro session
        ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
    }

    @GetMapping(value = "/error/403", produces = "application/json;charset=UTF-8")
    public String error403(HttpServletResponse response) {
        response.setStatus(403);
        return "sys/base/error/404";
    }

    @GetMapping(value = "/error/404", produces = "application/json;charset=UTF-8")
    public String error404(HttpServletResponse response) {
        response.setStatus(404);
        return "sys/base/error/404";
    }
}
