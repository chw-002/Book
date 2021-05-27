package com.wxxy.service.impl;

import com.wxxy.bean.User;
import com.wxxy.dao.UserDao;
import com.wxxy.dao.imp.UserDaoImpl;
import com.wxxy.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User login(String username, String password) {
        return userDao.queryUserByUsernameAndPassword(username, password);
    }

    @Override
    public int regist(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public boolean existUsername(String username) {
        User username1 = userDao.queryUserByUsername(username);
        if (username1 == null) {
            return false;
        }
        return true;
    }
}
