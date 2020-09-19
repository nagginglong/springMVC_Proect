package com.nagginglong.controller;

import com.nagginglong.entity.User;
import com.nagginglong.utils.ConstantsQantity;
import com.nagginglong.utils.Json2View;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * description:
 *
 * @author:像大山一样
 * @Date:2020/9/10 8:45
 */

@Controller
public class AccountController {

    @RequestMapping("/loginInfo")
    @ResponseBody
    public Json2View account(HttpServletRequest req){

        Json2View json2View = new Json2View();

        HttpSession session = req.getSession();

        User user = (User)session.getAttribute(ConstantsQantity.USER_NAME);

        if (user != null) {
            json2View.setStatus(1);
            json2View.setInfo(user);
        }else{
            json2View.setStatus(0);
            json2View.setInfo("用户未登录！");
        }


        return json2View;
    }
}
