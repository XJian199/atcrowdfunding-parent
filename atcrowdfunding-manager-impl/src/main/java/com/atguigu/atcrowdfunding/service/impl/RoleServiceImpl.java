package com.atguigu.atcrowdfunding.service.impl;

import com.atguigu.atcrowdfunding.bean.Datas;
import com.atguigu.atcrowdfunding.bean.Role;
import com.atguigu.atcrowdfunding.manager.dao.RoleDao;
import com.atguigu.atcrowdfunding.manager.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by XJian on 2017/8/8.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role queryRole(Map<String, Object> paramMap) {
        return roleDao.queryRole(paramMap);
    }

    public List<Role> pageQuery(Map<String, Object> paramMap) {
        return roleDao.pageQuery(paramMap);
    }

    public int queryCount(Map<String, Object> paramMap) {
        return roleDao.queryCount(paramMap);
    }

    public void insertRole(Role role) {
        roleDao.insertRole(role);
    }

    public Role queryById(Integer id) {
        return roleDao.queryById(id);
    }

    public int updateRole(Role role) {
        return roleDao.updateRole(role);
    }

    public int deleteRole(Integer id) {
        return roleDao.deleteRole(id);
    }

    public int deleteRoles(Datas ds) {
        return roleDao.deleteRoles(ds);
    }

    public List<Role> queryAll() {
        return roleDao.queryAll();
    }
}