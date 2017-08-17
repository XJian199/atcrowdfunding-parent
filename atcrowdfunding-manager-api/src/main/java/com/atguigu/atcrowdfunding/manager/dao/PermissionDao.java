package com.atguigu.atcrowdfunding.manager.dao;

import com.atguigu.atcrowdfunding.bean.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by XJian on 2017/8/8.
 */
@Repository
public interface PermissionDao {

    Permission queryRootNode();

    List<Permission> queryChildNodeByPid(Integer id);

    List<Permission> queryAll();

    void insertPermission(Permission permission);

    Permission queryById(Integer id);

    int updatePermission(Permission permission);

    int deletePermissoin(Permission permission);

}
