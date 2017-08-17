package com.atguigu.atcrowdfunding.manager.dao;

import com.atguigu.atcrowdfunding.bean.Datas;
import com.atguigu.atcrowdfunding.bean.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by XJian on 2017/8/8.
 */
@Repository
public interface RoleDao {

    Role queryRole(Map<String, Object> paramMap);

    List<Role> pageQuery(Map<String, Object> paramMap);

    int queryCount(Map<String, Object> paramMap);

    void insertRole(Role role);

    Role queryById(Integer id);

    int updateRole(Role role);

    int deleteRole(Integer id);

    int deleteRoles(Datas ds);

    List<Role> queryAll();

    void insertRolePermissions(Map<String, Object> paramMap);

    void deletePermissionsByRoleid(Map<String, Object> paramMap);

}