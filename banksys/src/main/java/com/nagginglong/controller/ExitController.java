package com.nagginglong.controller;

import com.nagginglong.entity.User;
import com.nagginglong.utils.ConstantsQantity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * description:
 *
 * @author:像大山一样
 * @Date:2020/9/16 20:12
 */

@Controller
public class ExitController {

    @RequestMapping("/exit.do")
    public String exit (HttpSession session){

//        session.setAttribute(ConstantsQantity.USER_NAME,null);

//        session.invalidate();

        User attribute = (User)session.getAttribute(ConstantsQantity.USER_NAME);


        session.removeAttribute(ConstantsQantity.USER_NAME);



        return "redirect:/login.html";
    }
}
