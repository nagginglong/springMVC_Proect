package com.nagginglong.service;

import com.nagginglong.entity.User;
import com.nagginglong.utils.Json2View;
import org.springframework.stereotype.Service;

/**
 * description:
 *
 * @author:像大山一样
 * @time:2020/9/9UserService
 */

public interface UserService {
    public User findUname(String uname, String password);
    public void upLoad(Integer uid,String img);

    public  User updateImg(String uname);
    public void insertInfo(String name,String password);
}
