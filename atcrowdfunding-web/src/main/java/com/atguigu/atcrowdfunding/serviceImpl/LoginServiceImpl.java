package com.atguigu.atcrowdfunding.serviceImpl;

import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.dao.LoginDao;
import com.atguigu.atcrowdfunding.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by XJian on 2017/8/8.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    public User queryUser4Login(User user) {

        return loginDao.queryUser4Login(user);

    }
}
