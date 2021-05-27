package com.wxxy.service;

import com.wxxy.bean.User;

public interface UserService {

    /**
     * 登录
     * @param username
     * @param password
     * @return 返回null 表示用户名或密码错误，登陆失败  有值说明成功
     */
    public User login(String username ,String password);

    /**
     * 注册
     * @param user
     * @return 返回 -1 表示注册失败  其他表示成功记录条数
     */
    public int regist(User user);

    /**
     *检查用户名是否可用
     * @param username
     * @return true用户名已存在   false用户名可用
     */
    public boolean existUsername(String username);
}
