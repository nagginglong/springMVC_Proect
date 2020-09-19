package com.nagginglong.controller;

import com.nagginglong.entity.User;
import com.nagginglong.service.UserService;
import com.nagginglong.utils.ConstantsQantity;
import com.nagginglong.utils.Json2View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * description:
 *
 * @author:像大山一样
 * @Date:2020/9/17 9:30
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/login.do")
    @ResponseBody
    public Json2View login(String tel, String password, HttpSession session){

        User user = userService.selectUser(tel, password);

        session.setAttribute(ConstantsQantity.USER_NAME,user);

        return new Json2View(1,"登录成功！",0,null);
    }

    @RequestMapping("/register.do")
    @ResponseBody
    public Json2View register(String tel,String password,String email,String invitation){

        userService.insertUser(tel, password, email,invitation);

        return new Json2View(1,"注册成功！",0,null);
    }

    @RequestMapping("/selectUser.do")
    @ResponseBody
    public Json2View selectUser(HttpSession session){
        User user = (User)session.getAttribute(ConstantsQantity.USER_NAME);

        User user1 = userService.selectUser(user.getTel(), user.getPassword());

        return new Json2View(1,"查询账号信息成功！",0,user1);

    }

    @RequestMapping("/updateUser.do")
    @ResponseBody
    public Json2View updateUser(@RequestParam("oldPassword")String oldPassword,
                                @RequestParam("newPassword")String newPassword,
                                @RequestParam("newPassword2")String newPassword2,
                                HttpSession session){

        User user = (User)session.getAttribute(ConstantsQantity.USER_NAME);

        userService.updateUser(user.getId(),newPassword);

        return new Json2View(1,"修改成功!",0,null);
    }


    @RequestMapping("/exitUser.do")
    public String exitUser(HttpServletRequest req,HttpSession session){

            session.removeAttribute(ConstantsQantity.USER_NAME);


        return "redirect:http://localhost:8080/carrental/index.html";
    }



}
