package com.atguigu.atcrowdfunding.manager.service;

import com.atguigu.atcrowdfunding.bean.Cert;
import com.atguigu.atcrowdfunding.bean.Datas;

import java.util.List;
import java.util.Map;

/**
 * Created by XJian on 2017/8/8.
 */
public interface CertService {
    public Cert queryCert(Map<String, Object> paramMap);

    public List<Cert> pageQuery(Map<String, Object> paramMap);

    public int queryCount(Map<String, Object> paramMap);

    public void insertCert(Cert cert);

    public Cert queryById(Integer id);

    public int updateCert(Cert cert);

    public int deleteCert(Integer id);

    public int deleteCerts(Datas ds);

    public List<Cert> queryAll();

    public void insertAcctTypeCert(Map<String, Object> paramMap);

    public void deleteAcctTypeCert(Map<String, Object> paramMap);

    public List<Map<String, Object>> queryAcctTypeCerts();

    public List<Map<String, Object>> queryAccttypeCerts();
}
