package com.nagginglong.dao;

import com.nagginglong.entity.User;

/**
 * description:
 *
 * @author:像大山一样
 * @time:2020/9/17UserDao
 */

public interface UserDao {
    public void updateUser(User user);
    public User selectUser(User user);
    public void insertUser(User user);
}
