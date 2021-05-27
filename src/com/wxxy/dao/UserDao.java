package com.wxxy.dao;

import com.wxxy.bean.User;

public interface UserDao {


    /**
     * 注册时 根据用户名查询用户是否可用
     * @param username
     * @return 返回null说明用户名不存在 即用户名可用
     */
    public User queryUserByUsername(String username);



    /**
     * 保存用户信息
     * @param user
     * @return 返回 -1表示注册失败
     */
    public int saveUser(User user);



    /**
     * 根据用户名和密码查询登录是否可用
     * @param username
     * @param password
     * @return 返回null 说明用户名或密码错误
     */
    public User queryUserByUsernameAndPassword(String username,String password);

}
