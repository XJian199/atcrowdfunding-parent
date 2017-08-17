package com.atguigu.atcrowdfunding.manager.service;

import com.atguigu.atcrowdfunding.bean.Permission;

import java.util.List;

/**
 * Created by XJian on 2017/8/8.
 */
public interface PermissionService {

    Permission queryRootNode();

    List<Permission> queryChildNodeByPid(Integer id);

    List<Permission> queryAll();

    void insertPermission(Permission permission);

    Permission queryById(Integer id);

    int updatePermission(Permission permission);

    int deletePermission(Permission permission);

}
