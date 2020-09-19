package com.nagginglong.controller;

import com.nagginglong.entity.User;
import com.nagginglong.service.UserService;
import com.nagginglong.utils.ConstantsQantity;
import com.nagginglong.utils.Json2View;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Size;

/**
 * description:
 *
 * @author:像大山一样
 * @Date:2020/9/9 20:32
 */

@Controller
@Validated//如果要在方法的参数上面使用验证注解，一定要先在这个类上写@Validated这样的注解
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login.do")
    @ResponseBody
    public Json2View login(@NotEmpty(message = "{name.empty}")String name,
                           @Size(min = 1, max = 10)String password, HttpSession session){

        User user = userService.findUname(name, password);

        session.setAttribute(ConstantsQantity.USER_NAME,user);

        Json2View json2View = new Json2View(1,null);

        return json2View;
    }



}
