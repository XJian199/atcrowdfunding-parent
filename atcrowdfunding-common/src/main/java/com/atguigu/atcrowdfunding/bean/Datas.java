package com.atguigu.atcrowdfunding.bean;

import java.util.List;

/**
 * 包装类
 * Created by XJian on 2017/8/8.
 */
public class Datas {

    private List<User> users ;
    private List<Integer> ids ;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
