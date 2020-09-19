package com.nagginglong.controller;

import com.nagginglong.entity.User;
import com.nagginglong.service.UserService;
import com.nagginglong.utils.ConstantsQantity;
import com.nagginglong.utils.Json2View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * description:
 *
 * @author:像大山一样
 * @Date:2020/9/12 16:35
 */

@Controller
public class UpdateImgController {
    @Autowired
    private UserService userService;

    @RequestMapping("/query.do")
    @ResponseBody
    public Json2View queryImg(HttpSession session){

        User attribute = (User)session.getAttribute(ConstantsQantity.USER_NAME);

        User user = userService.updateImg(attribute.getUname());

        return new Json2View(1,user);
    }

}
