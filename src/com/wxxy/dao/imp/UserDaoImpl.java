package com.wxxy.dao.imp;

import com.wxxy.bean.User;
import com.wxxy.dao.UserDao;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select * from t_user where username = ?";
        return queryForOne(sql,User.class,username);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(username,password,email) value(?,?,?) ";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select * from t_user where username = ? and password = ?";
        return queryForOne(sql,User.class,username,password);
    }
}
