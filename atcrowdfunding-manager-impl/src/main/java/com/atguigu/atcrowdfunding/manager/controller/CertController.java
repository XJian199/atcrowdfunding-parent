package com.atguigu.atcrowdfunding.manager.controller;

import com.atguigu.atcrowdfunding.bean.AJAXResult;
import com.atguigu.atcrowdfunding.bean.Cert;
import com.atguigu.atcrowdfunding.bean.Datas;
import com.atguigu.atcrowdfunding.bean.Page;
import com.atguigu.atcrowdfunding.common.BaseController;
import com.atguigu.atcrowdfunding.manager.service.CertService;
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
@RequestMapping("/cert")
public class CertController extends BaseController{

    @Autowired
    private CertService certService;


    @RequestMapping("/index")
    public String index() {
        return "manager/cert/index";
    }

    @RequestMapping("/add")
    public String add() {
        return "manager/cert/add";
    }

    @RequestMapping("/edit")
    public String edit( Integer id, Model model ) {

        // 根据主键查询资质信息
        Cert cert = certService.queryById(id);
        model.addAttribute("cert", cert);

        return "manager/cert/edit";
    }

    @ResponseBody
    @RequestMapping("/deletes")
    public Object deletes( Datas ds ) {
        AJAXResult result = new AJAXResult();

        try {
            int count = certService.deleteCerts(ds);
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
            int count = certService.deleteCert(id);
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
    public Object update( Cert cert ) {
        AJAXResult result = new AJAXResult();

        try {
            int count = certService.updateCert(cert);
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
     * 新增资质数据
     * @return
     */
    @ResponseBody
    @RequestMapping("/insert")
    public Object insert( Cert cert ) {
        AJAXResult result = new AJAXResult();

        try {
            certService.insertCert(cert);
            result.setSuccess(true);
        } catch ( Exception e ) {
            e.printStackTrace();
            result.setSuccess(false);
        }

        return result;
    }

    /**
     * 分页查询资质数据
     * @param pageno
     * @param pagesize
     * @return
     */
    @ResponseBody
    @RequestMapping("/pageQuery")
    public Object pageQuery(String pagetext, Integer pageno, Integer pagesize) {
        AJAXResult result = new AJAXResult();

        try {
            // 查询资质数据
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("start", (pageno-1)*pagesize);
            paramMap.put("size", pagesize);
            if ( StringUtil.isNotEmpty(pagetext) ) {
                //pagetext = pagetext.replaceAll("%", "\\%");
            }
            paramMap.put("pagetext", pagetext);

            // 分页查询数据
            List<Cert> certs = certService.pageQuery(paramMap);
            // 获取数据的总条数
            int count = certService.queryCount(paramMap);
            int totalno = 0;
            // 获取总页码
            if ( count % pagesize == 0) {
                totalno = count / pagesize;
            } else {
                totalno = count / pagesize + 1;
            }

            Page certPage = new Page<Cert>();
            certPage.setDatas(certs);
            certPage.setTotalno(totalno);
            certPage.setTotalsize(count);
            certPage.setPageno(pageno);
            certPage.setPagesize(pagesize);
            result.setData(certPage);
            result.setSuccess(true);
        } catch ( Exception e ) {
            e.printStackTrace();
            result.setSuccess(false);
        }

        return result;
    }
}