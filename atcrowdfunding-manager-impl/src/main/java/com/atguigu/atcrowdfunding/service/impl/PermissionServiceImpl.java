package com.atguigu.atcrowdfunding.service.impl;

import com.atguigu.atcrowdfunding.bean.Permission;
import com.atguigu.atcrowdfunding.manager.dao.PermissionDao;
import com.atguigu.atcrowdfunding.manager.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by XJian on 2017/8/8.
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    public Permission queryRootNode() {
        return permissionDao.queryRootNode();
    }

    public List<Permission> queryChildNodeByPid(Integer id) {
        // TODO Auto-generated method stub
        return permissionDao.queryChildNodeByPid(id);
    }

    public List<Permission> queryAll() {
        return permissionDao.queryAll();
    }

    public void insertPermission(Permission permission) {
        permissionDao.insertPermission(permission);
    }

    public Permission queryById(Integer id) {
        return permissionDao.queryById(id);
    }

    public int updatePermission(Permission permission) {
        return permissionDao.updatePermission(permission);
    }

    public int deletePermission(Permission permission) {
        return permissionDao.deletePermissoin(permission);
    }
}
