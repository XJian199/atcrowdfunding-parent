package com.atguigu.atcrowdfunding.manager.controller;

import com.atguigu.atcrowdfunding.bean.AJAXResult;
import com.atguigu.atcrowdfunding.bean.Datas;
import com.atguigu.atcrowdfunding.bean.Page;
import com.atguigu.atcrowdfunding.bean.Role;
import com.atguigu.atcrowdfunding.common.BaseController;
import com.atguigu.atcrowdfunding.manager.service.RoleService;
import com.atguigu.atcrowdfunding.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by XJian on 2017/8/8.
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/index")
    public String index() {
        return "manager/role/index";
    }

    @RequestMapping("/add")
    public String add() {
        return "manager/role/add";
    }

    @RequestMapping("/edit")
    public String edit( Integer id, Model model ) {

        // 根据主键查询角色信息
        Role role = roleService.queryById(id);
        model.addAttribute("role", role);

        return "manager/role/edit";
    }

    @RequestMapping("/assign")
    public String assign( Integer id, Model model ) {

        // 根据主键查询角色信息
        Role role = roleService.queryById(id);
        model.addAttribute("role", role);

        return "manager/role/assign";
    }

    @ResponseBody
    @RequestMapping("/deletes")
    public Object deletes( Datas ds ) {
        AJAXResult result = new AJAXResult();

        try {
            int count = roleService.deleteRoles(ds);
            if ( count == ds.getIds().size() ) {
                result.setSuccess(true);
            } else {
                result.setSuccess(false);
            }
        } catch ( Exception e ) {
            e.printStackTrace();
            result.setSuccess(false);
        }

        return result;
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Object delete( Integer id ) {
        AJAXResult result = new AJAXResult();

        try {
            int count = roleService.deleteRole(id);
            if ( count == 1 ) {
                result.setSuccess(true);
            } else {
                result.setSuccess(false);
            }
        } catch ( Exception e ) {
            e.printStackTrace();
            result.setSuccess(false);
        }

        return result;
    }

    @ResponseBody
    @RequestMapping("/update")
    public Object update( Role role ) {
        AJAXResult result = new AJAXResult();

        try {
            int count = roleService.updateRole(role);
            if ( count == 1 ) {
                result.setSuccess(true);
            } else {
                result.setSuccess(false);
            }
        } catch ( Exception e ) {
            e.printStackTrace();
            result.setSuccess(false);
        }

        return result;
    }

    /**
     * 新增角色数据
     * @return
     */
    @ResponseBody
    @RequestMapping("/insert")
    public Object insert( Role role ) {
        AJAXResult result = new AJAXResult();

        try {
            roleService.insertRole(role);
            result.setSuccess(true);
        } catch ( Exception e ) {
            e.printStackTrace();
            result.setSuccess(false);
        }

        return result;
    }

    /**
     * 分页查询角色数据
     * @param pageno
     * @param pagesize
     * @return
     */
    @ResponseBody
    @RequestMapping("/pageQuery")
    public Object pageQuery(String pagetext, Integer pageno, Integer pagesize) {
        AJAXResult result = new AJAXResult();

        try {
            // 查询角色数据
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("start", (pageno-1)*pagesize);
            paramMap.put("size", pagesize);
            if ( StringUtil.isNotEmpty(pagetext) ) {
                //pagetext = pagetext.replaceAll("%", "\\%");
            }
            paramMap.put("pagetext", pagetext);

            // 分页查询数据
            List<Role> roles = roleService.pageQuery(paramMap);
            // 获取数据的总条数
            int count = roleService.queryCount(paramMap);
            int totalno = 0;
            // 获取总页码
            if ( count % pagesize == 0) {
                totalno = count / pagesize;
            } else {
                totalno = count / pagesize + 1;
            }

            Page rolePage = new Page<Role>();
            rolePage.setDatas(roles);
            rolePage.setTotalno(totalno);
            rolePage.setTotalsize(count);
            rolePage.setPageno(pageno);
            rolePage.setPagesize(pagesize);
            result.setData(rolePage);
            result.setSuccess(true);
        } catch ( Exception e ) {
            e.printStackTrace();
            result.setSuccess(false);
        }

        return result;
    }
}
