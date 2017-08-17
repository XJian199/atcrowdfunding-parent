package com.atguigu.atcrowdfunding.util;

/**
 * Created by XJian on 2017/8/8.
 */
public class StringUtil {

    public static boolean isEmpty(String content) {
        return content == null || "".equals(content) ;
    }

    public static boolean isNotEmpty(String content) {
        return !isEmpty(content) ;
    }
}
