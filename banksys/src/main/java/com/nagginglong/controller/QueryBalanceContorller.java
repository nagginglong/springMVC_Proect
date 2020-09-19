package com.nagginglong.controller;

import com.nagginglong.dao.UserDao;
import com.nagginglong.entity.User;
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
 * @Date:2020/9/16 19:53
 */

@Controller
public class QueryBalanceContorller {
    @Autowired
    private UserDao userDao;

    @RequestMapping("/queryBalance.do")
    @ResponseBody
    public Json2View queryBalance(HttpSession session){

        User u = (User)session.getAttribute(ConstantsQantity.USER_NAME);

        User user = userDao.findUname(u.getUname());

        return new Json2View(1,user.getUbalance());
    }
}
