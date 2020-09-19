package com.nagginglong.dao;

import com.nagginglong.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * description:
 *
 * @author:像大山一样
 * @time:2020/9/9UserDao
 */


public interface UserDao {
    public User findUname(String uname);
    public void update(User user);
    public void insertInfo(User user);

}
