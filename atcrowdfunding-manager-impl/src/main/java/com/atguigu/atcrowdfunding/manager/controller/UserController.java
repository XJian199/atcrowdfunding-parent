package com.atguigu.atcrowdfunding.manager.controller;

import com.atguigu.atcrowdfunding.bean.*;
import com.atguigu.atcrowdfunding.common.BaseController;
import com.atguigu.atcrowdfunding.manager.service.RoleService;
import com.atguigu.atcrowdfunding.manager.service.UserService;
import com.atguigu.atcrowdfunding.util.MD5Util;
import com.atguigu.atcrowdfunding.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by XJian on 2017/8/8.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    /**
     * 跳转到用户查询页面
     *
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        return "manager/user/index";
    }

    /**
     * 跳转到用户新增页面
     *
     * @return
     */
    @RequestMapping("/add")
    public String add() {
        return "manager/user/add";
    }

    /**
     * 跳转到用户批量新增页面
     *
     * @return
     */
    @RequestMapping("/addBatch")
    public String addBatch() {
        return "manager/user/addBatch";
    }

    /**
     * 跳转到用户修改页面
     *
     * @return
     */
    @RequestMapping("/edit")
    public String edit(Integer id, Model model) {
        User user = userService.queryById(id);
        model.addAttribute("user", user);
        return "manager/user/edit";
    }

    /**
     * 跳转到用户角色分配页面
     *
     * @return
     */
    @RequestMapping("/assign")
    public String assign(Integer id, Model model) {
        User user = userService.queryById(id);
        model.addAttribute("user", user);

        // 查询所有的角色数据
        List<Role> roles = roleService.queryAll();
        // 未分配集合
        List<Role> unassingList = new ArrayList<Role>();
        // 已分配集合
        List<Role> assingList = new ArrayList<Role>();
        // 查询当前用户已经分配的角色ID集合
        List<Integer> roleids = userService.queryRoleidsByUserid(id);
        for (Role role : roles) {
            if (roleids.contains(role.getId())) {
                assingList.add(role);
            } else {
                unassingList.add(role);
            }
        }

        model.addAttribute("assignList", assingList);
        model.addAttribute("unassignList", unassingList);

        return "manager/user/assign";
    }

    /**
     * 分配角色
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/assignRole")
    public Object assignRole(Integer userid, Datas ds) {
        start();

        try {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("userid", userid);
            paramMap.put("roleids", ds.getIds());
            userService.insertUserRoles(paramMap);
            success();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        return end();
    }

    /**
     * 取消分配角色
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/unassignRole")
    public Object unassignRole(Integer userid, Datas ds) {
        start();

        try {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("userid", userid);
            paramMap.put("roleids", ds.getIds());
            userService.deleteUserRoles(paramMap);
            success();
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        return end();
    }

    /**
     * 删除用户信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public Object delete(Integer id) {
        start();

        try {
            int cnt = userService.deleteById(id);
            success(cnt == 1);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

        return end();
    }

    /**
     * 批量删除用户s信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/deletes")
    public Object deletes(Datas ds) {
        AJAXResult result = new AJAXResult();

        try {
            int cnt = userService.deletesByUsers(ds);
            result.setSuccess(cnt == ds.getIds().size());
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }

        return result;
    }

    /**
     * 修改用户信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/update")
    public Object update(User user) {
        AJAXResult result = new AJAXResult();

        try {
            int cnt = userService.updateUser(user);
            result.setSuccess(cnt == 1);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }

        return result;
    }

    /**
     * 批量新增用户信息
     * 1) 使用数组的方式可以接收表单中多条相同名称的数据
     * loginacct=zhangsan&loginacct=lisi
     * 2) 将页面中传递的多条数据在后台封装成对象集合
     * a) 增加一个包装类 ：Datas
     * b) 在包装类中增加对象的集合属性users,并增加set, get方法
     * c) 表单数据的传递方式：集合属性名称[索引].对象属性名称=123
     * users[0].loginacct=zhangsan&users[1].loginacct=lisi
     *
     * @return
     */
    @RequestMapping("/inserts")
    public String inserts(Datas ds) {

        AJAXResult result = new AJAXResult();
        try {
            List<User> users = ds.getUsers();
            Iterator<User> iterator = users.iterator();

            while (iterator.hasNext()) {
                User user = iterator.next();
                if (StringUtil.isEmpty(user.getLoginacct())) {
                    iterator.remove();
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
                String createtime = sdf.format(new Date());
                user.setCreatetime(createtime);
                user.setUserpswd(MD5Util.digest("123456"));
            }
            result.setData(users);
            userService.batchInsertUsers(ds);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return "redirect:/user/index.htm";
    }

    /**
     * 新增用户信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/insert")
    public Object insert(User user) {

        AJAXResult result = new AJAXResult();

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = sdf.format(new Date());
            user.setCreatetime(date);
            user.setUserpswd(MD5Util.digest("123456"));
            userService.insertUser(user);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }

        return result;
    }

    /**
     * 分页查询用户信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/pageQuery")
    public Object pageQuery(String querytext, Integer pageno, Integer pagesize) {

        AJAXResult result = new AJAXResult();

        try {

            Page userPage = new Page<User>();
            System.out.println("userpage............." + userPage);
            userPage.setPageno(pageno);
            userPage.setPagesize(pagesize);

            // 查询用户信息
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("start", (pageno - 1) * pagesize);
            paramMap.put("size", pagesize);
            if (StringUtil.isNotEmpty(querytext)) {
                if (querytext.indexOf("\\") != -1) {
                    querytext = querytext.replaceAll("\\\\", "\\\\\\\\");
                }
                if (querytext.indexOf("%") != -1) {
                    querytext = querytext.replaceAll("%", "\\\\%");
                }
                if (querytext.indexOf("_") != -1) {
                    querytext = querytext.replaceAll("_", "\\\\_");
                }
                paramMap.put("querytext", querytext);
            }
            // 数据
            List<User> users = userService.queryPageData(paramMap);
            // 总的数据条数
            int count = userService.queryPageCount(paramMap);
            userPage.setTotalsize(count);
            // 总页码
            int totalno = 0;
            if (count % pagesize == 0) {
                totalno = count / pagesize;
            } else {
                totalno = count / pagesize + 1;
            }
            userPage.setTotalno(totalno);
            userPage.setDatas(users);

            result.setData(userPage);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }

        return result;
    }

//	@RequestMapping("/index")
//	public String index( @RequestParam(required=false,defaultValue="1")Integer pageno, @RequestParam(required=false,defaultValue="2")Integer pagesize, Model model ) {
//
//		// 查询用户信息
//		Map<String, Object> paramMap = new HashMap<String, Object>();
//		paramMap.put("start", (pageno-1)*pagesize);
//		paramMap.put("size", pagesize);
//
//		List<User> users = userService.queryPageData(paramMap);
//		model.addAttribute("users", users);
//
//		return "manager/user/index";
//	}
}
