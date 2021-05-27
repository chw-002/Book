package com.wxxy.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class WebUtils {

    //把Map中的对象注入到bean中
    public static <T> T copyParamToBean(Map value,T bean){

        try {
            BeanUtils.populate(bean,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    //把字符串转换成整型
    public static int parseInt(String string,int defaultValue){
        try {
            return Integer.parseInt(string);
        } catch (Exception e) {
  //          e.printStackTrace();
        }
        return defaultValue;
    }
}
