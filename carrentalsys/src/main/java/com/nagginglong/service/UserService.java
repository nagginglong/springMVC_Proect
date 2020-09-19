package com.nagginglong.service;

import com.nagginglong.entity.User;

/**
 * description:
 *
 * @author:像大山一样
 * @time:2020/9/17UserService
 */
public interface UserService {
    public User selectUser(String tel,String password);
    public void insertUser(String tel,String password,String email,String invitation);
    public void updateUser(Integer id,String password);
}
