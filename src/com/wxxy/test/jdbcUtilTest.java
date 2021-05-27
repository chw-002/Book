package com.wxxy.test;


import com.wxxy.utils.JdbcUtil;
import org.junit.Test;

public class jdbcUtilTest {
    @Test
    public void jdbcTest(){
        System.out.println(JdbcUtil.getConn());
        JdbcUtil.closeConn(JdbcUtil.getConn());
    }
}
