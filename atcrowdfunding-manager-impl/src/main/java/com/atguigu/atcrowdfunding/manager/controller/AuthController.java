package com.atguigu.atcrowdfunding.manager.controller;

import com.atguigu.atcrowdfunding.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by XJian on 2017/8/9.
 */
@Controller
@RequestMapping("/auth")
public class AuthController extends BaseController {

    /**
     * 实名认证审核首页
     *
     * @return
     */
    @RequestMapping("/cert")
    public String cert() {
        return "manager/auth/auth_cert";
    }

    /**
     * 跳转到广告审核首页
     *
     * @return
     */
    @RequestMapping("/adv")
    public String adv() {
        return "manager/auth/auth_adv";
    }

    /**
     * 跳转到项目审核首页
     *
     * @return
     */
    @RequestMapping("/project")
    public String project() {
        return "manager/auth/auth_project";
    }
}
