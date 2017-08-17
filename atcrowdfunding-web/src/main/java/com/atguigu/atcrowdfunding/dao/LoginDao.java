package com.atguigu.atcrowdfunding.dao;

import com.atguigu.atcrowdfunding.bean.User;
import org.springframework.stereotype.Repository;

/**
 * Created by XJian on 2017/8/8.
 */
@Repository
public interface LoginDao {

    User queryUser4Login(User user) ;

}
