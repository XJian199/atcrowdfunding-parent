package com.atguigu.atcrowdfunding.manager.dao;

import com.atguigu.atcrowdfunding.bean.Datas;
import com.atguigu.atcrowdfunding.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by XJian on 2017/8/8.
 */
@Repository
public interface UserDao {

    List<User> queryPageData(Map<String, Object> paramMap);

    int queryPageCount(Map<String, Object> paramMap);

    void insertUser(User user);

    User queryById(Integer id);

    // DML insert, update, delete
    // DQL select
    int updateUser(User user);

    int deleteById(Integer id);

    int deletesByUsers(Datas ds);

    void insertUserRoles(Map<String, Object> paramMap);

    void deleteUserRoles(Map<String, Object> paramMap);

    List<Integer> queryRoleidsByUserid(Integer id);

    int batchInsertUsers(Datas ds);
}
