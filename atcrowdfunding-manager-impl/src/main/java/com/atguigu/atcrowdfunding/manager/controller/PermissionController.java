package com.atguigu.atcrowdfunding.manager.controller;

import com.atguigu.atcrowdfunding.bean.Permission;
import com.atguigu.atcrowdfunding.common.BaseController;
import com.atguigu.atcrowdfunding.manager.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by XJian on 2017/8/8.
 */
@Controller
@RequestMapping("/permission")
public class PermissionController extends BaseController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/index")
    public String index() {
        return "manager/permission/index";
    }

    @RequestMapping("/add")
    public String add() {
        return "manager/permission/add";
    }

    @RequestMapping("/edit")
    public String edit( Integer id, Model model ) {

        Permission permission = permissionService.queryById(id);
        model.addAttribute("permission", permission);

        return "manager/permission/edit";
    }

    /**
     * 新增许可数据
     * @return
     */
    @ResponseBody
    @RequestMapping("/insert")
    public Object insert( Permission permission ) {
        start();

        try {
            permissionService.insertPermission(permission);
            success();
        } catch ( Exception e ) {
            e.printStackTrace();
            fail();
        }

        return end();
    }

    /**
     * 修改许可数据
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public Object update( Permission permission ) {
        start();

        try {
            int cnt = permissionService.updatePermission(permission);
            success(cnt == 1);
        } catch ( Exception e ) {
            e.printStackTrace();
            fail();
        }

        return end();
    }

    /**
     * 删除许可数据
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public Object delete( Permission permission ) {
        start();

        try {
            int cnt = permissionService.deletePermission(permission);
            success(cnt == 1);
        } catch ( Exception e ) {
            e.printStackTrace();
            fail();
        }

        return end();
    }

    /**
     * 查询子节点数据
     * @param parent
     */
    private void queryChildNode( Permission parent ) {
        List<Permission> childPermissions = permissionService.queryChildNodeByPid(parent.getId());
        for ( Permission childPermission : childPermissions ) {
            queryChildNode(childPermission);
        }
        // 组合父子节点之间的关系
        parent.setChildren(childPermissions);
    }

    @ResponseBody
    @RequestMapping("/loadAJAXDatas")
    public Object loadAJAXDatas() {
        List<Permission> permissions = permissionService.queryAll();
        List<Permission> roots = new ArrayList<Permission>();
        Map<Integer, Permission> permissionMap = new HashMap<Integer, Permission>();

        for ( Permission permission : permissions ) {
            permissionMap.put(permission.getId(), permission);
        }

        for ( Permission permission : permissions ) {
            Permission child = permission;
            if ( child.getPid() == 0 ) {
                roots.add(permission);
            } else {
                Permission parent = permissionMap.get(child.getPid());
                parent.getChildren().add(child);
            }
        }
        return roots;
    }

    /**
     * 读取许可树形数据
     * 1) 递归 （5! = 5 * 4! = 5 * 4 * 3! = 5 * 4 * 3 * 2! = 5 * 4 * 3 * 2 * 1）
     * 		a) 方法不断调用自身
     *      b) 方法调用时，应该存在跳出的逻辑
     *      c) 方法调用时，传递的参数之间应该有规律
     * @return
     */
    @ResponseBody
    @RequestMapping("/loadDatas")
    public Object loadDatas() {
        start();

        try {

//			Permission p = new Permission();
//			p.setName("xxxxx");
//			p.setOpen(true);
//
//			Permission p1 = new Permission();
//			p1.setName("yyyyyy");
//
//			Permission p2 = new Permission();
//			p2.setName("zzzzzz");
//
//			List<Permission> children = new ArrayList<Permission>();
//			children.add(p1);
//			children.add(p2);
//
//			p.setChildren(children);
//
//			// 查询父菜单
//			Permission root = permissionService.queryRootNode();
//
//			// 再查询子菜单
//			List<Permission> childPermissions =
//				permissionService.queryChildNodeByPid(root.getId());
//
//			// 组合父子菜单的关系
//			root.setChildren(childPermissions);
//
//			for ( Permission childPermission : childPermissions ) {
//				List<Permission> childChildPermissions =
//						permissionService.queryChildNodeByPid(childPermission.getId());
//
//				for ( Permission childChildPermission : childChildPermissions ) {
//					List<Permission> childChildChildPermissions =
//							permissionService.queryChildNodeByPid(childChildPermission.getId());
//
//
//
//					childChildPermission.setChildren(childChildChildPermissions);
//				}
//
//				childPermission.setChildren(childChildPermissions);
//			}

            // 使用递归方式读取许可数据
            //Permission permission = new Permission();
            //permission.setId(0);

            //queryChildNode(permission);

            //data(permission.getChildren());

            // 查询所有的许可数据
            // 使用嵌套for循环整合许可数据
            List<Permission> permissions = permissionService.queryAll();
            List<Permission> roots = new ArrayList<Permission>();
//			for ( Permission permission : permissions ) {
//				// 子节点
//				Permission child = permission;
//
//				if ( child.getPid() == 0 ) {
//					roots.add(permission);
//				} else {
//					for ( Permission innerPermission : permissions ) {
//						if ( child.getPid() == innerPermission.getId() ) {
//							// 父节点
//							Permission parent = innerPermission;
//							// 组合父子节点的关系
//							parent.getChildren().add(child);
//							break;
//						}
//					}
//				}
//			}

            // 使用map集合封装父节点数据，整合许可数据
            Map<Integer, Permission> permissionMap = new HashMap<Integer, Permission>();

            for ( Permission permission : permissions ) {
                permissionMap.put(permission.getId(), permission);
            }

            for ( Permission permission : permissions ) {
                Permission child = permission;
                if ( child.getPid() == 0 ) {
                    roots.add(permission);
                } else {
                    Permission parent = permissionMap.get(child.getPid());
                    parent.getChildren().add(child);
                }
            }

            data(roots);
            success();
        } catch ( Exception e ) {
            e.printStackTrace();
            fail();
        }

        return end();
    }
}