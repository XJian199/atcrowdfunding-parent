package com.atguigu.atcrowdfunding.service.impl;

import com.atguigu.atcrowdfunding.bean.Cert;
import com.atguigu.atcrowdfunding.bean.Datas;
import com.atguigu.atcrowdfunding.manager.dao.CertDao;
import com.atguigu.atcrowdfunding.manager.service.CertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by XJian on 2017/8/8.
 */
@Service
public class CertServiceImpl implements CertService {

    @Autowired
    private CertDao certDao;

    public Cert queryCert(Map<String, Object> paramMap) {
        return certDao.queryCert(paramMap);
    }

    public List<Cert> pageQuery(Map<String, Object> paramMap) {
        return certDao.pageQuery(paramMap);
    }

    public int queryCount(Map<String, Object> paramMap) {
        return certDao.queryCount(paramMap);
    }

    public void insertCert(Cert cert) {
        certDao.insertCert(cert);
    }

    public Cert queryById(Integer id) {
        return certDao.queryById(id);
    }

    public int updateCert(Cert cert) {
        return certDao.updateCert(cert);
    }

    public int deleteCert(Integer id) {
        return certDao.deleteCert(id);
    }

    public int deleteCerts(Datas ds) {
        return certDao.deleteCerts(ds);
    }

    public List<Cert> queryAll() {
        return certDao.queryAll();
    }

    public void insertAcctTypeCert(Map<String, Object> paramMap) {
        certDao.insertAcctTypeCert(paramMap);
    }

    public void deleteAcctTypeCert(Map<String, Object> paramMap) {
        certDao.deleteAcctTypeCert(paramMap);
    }

    public List<Map<String, Object>> queryAcctTypeCerts() {
        return certDao.queryAcctTypeCerts();
    }

    public List<Map<String, Object>> queryAccttypeCerts() {
        return certDao.queryAcctTypeCerts();
    }

}
