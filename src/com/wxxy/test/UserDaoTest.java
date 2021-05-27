package com.wxxy.test;

import com.wxxy.bean.User;
import com.wxxy.dao.UserDao;
import com.wxxy.dao.imp.UserDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {

    private UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUserByUsername() {
        User username = userDao.queryUserByUsername("admin");
        if(username == null){
            System.out.println("用户名可用");
        }else {
            System.out.println("用户名已存在");
        }
    }

    @Test
    public void saveUser() {
        int i = userDao.saveUser(new User(null, "chw222", "123123", "chw@qq.com"));
        if (i == -1) {
            System.out.println("注册失败，用户名已存在");
        }else {
            System.out.println("注册成功");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        User user = userDao.queryUserByUsernameAndPassword("admin", "admin");
        if (user == null) {
            System.out.println("用户名或密码错误");
        }else {
            System.out.println("登陆成功");
        }
    }
}