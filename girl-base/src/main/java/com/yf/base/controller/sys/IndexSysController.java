package com.yf.base.controller.sys;

import com.yf.base.config.shrio.ShiroUtils;
import com.yf.base.entiy.R;
import com.yf.base.service.SysMenuService;
import com.yf.utils.BaseController;
import com.yf.utils.MD5Utils;
import com.yf.utils.Page;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName IndexAdminController
 * @Description
 * @Date 2018/5/3 16:13
 * @Author jinghan
 * @Version 1.0
 */
@Controller
@RequestMapping(value = "/sys")
public class IndexSysController extends BaseController {

    @Resource(name = "sysMenuService")
    private SysMenuService sysMenuService;

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView hello(Page page){
        ModelAndView mv = this.getModelAndView();
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.setViewName("sys/index");
        return mv;
    }

    @RequestMapping("/goLogin")
    public String goLogin(){
        return "sys/base/login";
    }



    /**
     * 登录
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public R login(HttpServletRequest request){
        try{
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String captcha = request.getParameter("captcha");
//            String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
//            if(!captcha.equalsIgnoreCase(kaptcha)){
//                return R.error("验证码不正确");
//            }
            Subject subject = ShiroUtils.getSubject();
            //sha256加密
            password = MD5Utils.encrypt(username, password);
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            if(request.getParameter("rememberMe")!=null){
                token.setRememberMe(true);
            }
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
        return "redirect:sys/goLogin";
    }
}
