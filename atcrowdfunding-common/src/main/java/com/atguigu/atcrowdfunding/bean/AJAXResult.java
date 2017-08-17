package com.atguigu.atcrowdfunding.bean;

/**
 * Created by XJian on 2017/8/8.
 */
public class AJAXResult {

    private boolean success ;
    private Object data ;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
