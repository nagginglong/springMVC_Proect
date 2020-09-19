package com.nagginglong.service.impl;

import com.nagginglong.dao.UserDao;
import com.nagginglong.entity.User;
import com.nagginglong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * description:
 *
 * @author:像大山一样
 * @Date:2020/9/17 9:35
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public User selectUser(String tel, String password) {
        User user = new User();
        user.setTel(tel);
        User user1 = userDao.selectUser(user);

        if (user1 == null) {
            throw new RuntimeException("账号不存在！");
        }

        if (!user1.getPassword().equals(password)) {
            throw new RuntimeException("密码错误！");
        }

        return user1;
    }

    @Override
    public void insertUser(String tel, String password, String email, String invitation) {
        User user = new User();
        user.setTel(tel);
        user.setPassword(password);
        user.setEmail(email);
        user.setInvitation(invitation);

        userDao.insertUser(user);
    }

    @Override
    public void updateUser(Integer id, String password) {
        User user = new User();
        user.setId(id);
        user.setPassword(password);

        userDao.updateUser(user);
    }
}
