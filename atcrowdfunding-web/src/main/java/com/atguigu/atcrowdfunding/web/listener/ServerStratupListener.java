package com.atguigu.atcrowdfunding.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by XJian on 2017/8/8.
 */
public class ServerStratupListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {

        //将web应用路径保存到应用范围中

        //web应用
        ServletContext application = sce.getServletContext();

        //路径
        String path = application.getContextPath();

        //保存
        application.setAttribute("APP_PATH", path);
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }
}
