package com.yf.core.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.yf.core.config.shrio.ShiroUtils;
import com.yf.core.service.SysUserService;
import com.yf.utils.BaseController;
import com.yf.utils.MD5Utils;
import com.yf.utils.R;
import com.yf.utils.RedisUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 用户controller
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月8日 下午2:48:50
 */
@Controller
@RequestMapping("/sys")
public class SysLoginController extends BaseController{

    @Autowired
    private Producer producer;

    @Autowired
    private RedisUtils redisUtils;

	/**
	 * 验证码
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/captcha.jpg")
	public void captcha(HttpServletResponse response)throws ServletException, IOException {
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




	/**
	 * 登录
	 */
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public R login(String username, String password, String captcha){
		try{

			Subject subject = ShiroUtils.getSubject();
			//sha256加密
			password = MD5Utils.encrypt(username, password);
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            System.out.println("redisUtils.getStr(\"asd\") : "+redisUtils.getStr("asd"));
			subject.login(token);
		}catch (UnknownAccountException e) {
            logger.error(e.toString(),e);
			return R.error(e.getMessage());
		}catch (IncorrectCredentialsException e) {
            logger.error(e.toString(),e);
			return R.error(e.getMessage());
		}catch (LockedAccountException e) {
            logger.error(e.toString(),e);
			return R.error(e.getMessage());
		}catch (AuthenticationException e) {
            logger.error(e.toString(),e);
			return R.error("账户验证失败");
		}
		return R.ok();
	}
	
	/**
	 * 退出系统
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		ShiroUtils.logout();
		return "redirect:login.html";
	}
}
