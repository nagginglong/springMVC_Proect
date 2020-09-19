package com.nagginglong.controller;

import com.nagginglong.dao.UserDao;
import com.nagginglong.entity.User;
import com.nagginglong.service.UserService;
import com.nagginglong.utils.Json2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * description:
 *
 * @author:像大山一样
 * @Date:2020/9/16 21:29
 */

@Controller
public class RegisterController {
    @Autowired
    private UserService userService;

    @RequestMapping("/register.do")
    @ResponseBody
    public Json2 register(String name, String password){

        User user = new User();

        user.setUpassword(password);

        user.setUname(name);

        userService.insertInfo(name,password);

        return new Json2(1,"注册成功！",0,null) ;
    }
}
