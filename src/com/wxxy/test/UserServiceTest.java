package com.wxxy.test;

import com.wxxy.bean.User;
import com.wxxy.service.UserService;
import com.wxxy.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    UserService userService = new UserServiceImpl();
    @Test
    public void login() {
        User user = userService.login("admin", "admin");
        System.out.println(user);
    }

    @Test
    public void regist() {
        int i = userService.regist(new User(null, "chw333", "123456", "chw@qq.com"));
        System.out.println(i);
    }

    @Test
    public void existUsername() {
        boolean username = userService.existUsername("admin");
        System.out.println(username);
    }
}