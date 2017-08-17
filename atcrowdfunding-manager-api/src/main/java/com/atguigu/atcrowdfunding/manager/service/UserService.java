package com.atguigu.atcrowdfunding.manager.service;

import com.atguigu.atcrowdfunding.bean.Datas;
import com.atguigu.atcrowdfunding.bean.User;

import java.util.List;
import java.util.Map;

/**
 * Created by XJian on 2017/8/8.
 */
public interface UserService {

    List<User> queryPageData(Map<String, Object> paramMap);

    int queryPageCount(Map<String, Object> paramMap);

    void insertUser(User user);

    User queryById(Integer id);

    int updateUser(User user);

    int deleteById(Integer id);

    int deletesByUsers(Datas ds);

    void insertUserRoles(Map<String, Object> paramMap);

    void deleteUserRoles(Map<String, Object> paramMap);

    List<Integer> queryRoleidsByUserid(Integer id);

    void batchInsertUsers(Datas ds);
}