package com.atguigu.atcrowdfunding.bean;

import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * Created by XJian on 2017/8/8.
 */
public class Page<T> {

    private int pageno;
    private int pagesize;
    private int totalno;
    private int totalsize;
    private List<T> datas;

    public int getPageno() {
        return pageno;
    }

    public void setPageno(int pageno) {
        this.pageno = pageno;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getTotalno() {
        return totalno;
    }

    public void setTotalno(int totalno) {
        this.totalno = totalno;
    }

    public int getTotalsize() {
        return totalsize;
    }

    public void setTotalsize(int totalsize) {
        this.totalsize = totalsize;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }
}
