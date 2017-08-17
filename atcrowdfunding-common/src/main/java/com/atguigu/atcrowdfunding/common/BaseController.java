package com.atguigu.atcrowdfunding.common;

import com.atguigu.atcrowdfunding.bean.AJAXResult;

/**
 * Created by XJian on 2017/8/8.
 */
public abstract class BaseController {

    private ThreadLocal<AJAXResult> resultLocal = new ThreadLocal<AJAXResult>();

    protected void start() {
        resultLocal.set(new AJAXResult());
    }

    protected Object end() {
        Object obj = resultLocal.get();
        resultLocal.remove();
        return obj;
    }

    protected void data(Object obj) {
        AJAXResult result = resultLocal.get();
        result.setData(obj);
    }

    protected void success() {
        AJAXResult result = resultLocal.get();
        result.setSuccess(true);
    }

    protected void success(boolean flg) {
        AJAXResult result = resultLocal.get();
        result.setSuccess(flg);
    }

    protected void fail() {
        AJAXResult result = resultLocal.get();
        result.setSuccess(false);
    }
}













