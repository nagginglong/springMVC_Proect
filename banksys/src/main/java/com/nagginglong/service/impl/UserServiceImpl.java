package com.nagginglong.service.impl;

import com.nagginglong.dao.UserDao;
import com.nagginglong.entity.User;
import com.nagginglong.service.UserService;
import com.nagginglong.utils.Json2View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * description:
 *
 * @author:像大山一样
 * @Date:2020/9/9 20:35
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public User findUname(String uname, String password) {

        User user = userDao.findUname(uname);

        if (user == null) {
            throw new RuntimeException("账户错误");
        }

        if (!user.getUpassword().equals(password)){
            throw new RuntimeException("密码错误");
        }

        return user;
    }

    @Override
    public void upLoad(Integer uid, String img) {
        User user = new User();
        user.setUid(uid);
        user.setUimgPath(img);

        userDao.update(user);
    }

    @Override
    public User updateImg(String uname) {

        User user = userDao.findUname(uname);

        return user;
    }

    @Override
    public void insertInfo(String name, String password) {

        User user = new User();

        user.setUname(name);
        user.setUpassword(password);

        userDao.insertInfo(user);

    }


}
