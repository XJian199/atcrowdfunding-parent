package com.atguigu.atcrowdfunding.service.impl;

import com.atguigu.atcrowdfunding.bean.Datas;
import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.manager.dao.UserDao;
import com.atguigu.atcrowdfunding.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by XJian on 2017/8/8.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public List<User> queryPageData(Map<String, Object> paramMap) {
        return userDao.queryPageData(paramMap);
    }

    public int queryPageCount(Map<String, Object> paramMap) {
        return userDao.queryPageCount(paramMap);
    }

    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    public User queryById(Integer id) {
        return userDao.queryById(id);
    }

    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    public int deleteById(Integer id) {
        return userDao.deleteById(id);
    }

    public int deletesByUsers(Datas ds) {
        return userDao.deletesByUsers(ds);
    }

    public void insertUserRoles(Map<String, Object> paramMap) {
        userDao.insertUserRoles(paramMap);
    }

    public void deleteUserRoles(Map<String, Object> paramMap) {
        userDao.deleteUserRoles(paramMap);
    }

    public List<Integer> queryRoleidsByUserid(Integer id) {
        return userDao.queryRoleidsByUserid(id);
    }

    public void batchInsertUsers(Datas ds) {
        userDao.batchInsertUsers(ds) ;
    }
}
