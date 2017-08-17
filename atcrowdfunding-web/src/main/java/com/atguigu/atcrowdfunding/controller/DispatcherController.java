package com.atguigu.atcrowdfunding.controller;

import com.atguigu.atcrowdfunding.bean.AJAXResult;
import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.manager.service.UserService;
import com.atguigu.atcrowdfunding.service.LoginService;
import com.atguigu.atcrowdfunding.util.MD5Util;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by XJian on 2017/8/8.
 */
@Controller
public class DispatcherController {

    @Autowired
    private UserService userService;
    @Autowired
    private LoginService loginService;

    /**
     * 执行登陆操作，根据结果跳转到不同的页面
     *
     * @return
     */

    //@ResponseBody : 将返回的对象转换为字符串  .
    @ResponseBody
    @RequestMapping("/doLogin")
    public Object doLogin(User user, HttpSession session) {
        AJAXResult result = new AJAXResult();
        user.setUserpswd(MD5Util.digest(user.getUserpswd()));
        User dbUser = loginService.queryUser4Login(user);
        if (dbUser == null) {
            result.setSuccess(false);
        } else {
            //model.addAttribute("loginUser", dbUser);
            session.setAttribute("loginUser", dbUser);
            result.setSuccess(true);
        }
        return result;
    }


//	@RequestMapping("/doLogin")
//	public String doLogin( User user, Model model ) {
//
//		// 获取用户传递的数据
//
//		// 查询用户信息（账号，密码）
//		User dbUser = loginService.queryUser4Login(user);
//		if ( dbUser != null ) {
//			return "main";
//		} else {
//			// model中存储数据等同于向请求范围内存储数据
//			model.addAttribute("errorMsg", "用户不存在，请重新操作");
//			model.addAttribute("loginacct", user.getLoginacct());
//			model.addAttribute("user", user);
//			return "redirect:/login.htm";
//		}
//	}

    /**
     * 跳转到项目的首页
     *
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * 跳转到登陆页面
     *
     * @return login
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 跳转到注册成功页面
     *
     * @return
     */
    @RequestMapping("/member")
    public String member() {
        return "member";
    }

    /**
     * 跳转到项目页面
     *
     * @return
     */
    @RequestMapping("project")
    public String project() {
        return "project";
    }


    /**
     * 跳转到注册页面
     *
     * @return
     */
    @RequestMapping("/reg")
    public String reg() {
        return "reg";
    }

    /**
     * 退出系统
     *
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        //session.removeAttribute("loginUser");
        session.invalidate();
        return "redirect:/login.htm";
    }

    /**
     * 跳转到后台管理主页面
     *
     * @return
     */
    @RequestMapping("/main")
    public String main() {
        return "main";
    }

//    /**
//     * 跳转到开始众筹页面
//     *
//     * @return
//     */
//    @RequestMapping("/start")
//    public String start() {
//        return "start";
//    }
//
//    /**
//     * 跳转到我的众筹页面
//     *
//     * @return
//     */
//    @RequestMapping("/minecrowdfunding")
//    public String minecrowdfunding() {
//        return "project/minecrowdfunding";
//    }
}