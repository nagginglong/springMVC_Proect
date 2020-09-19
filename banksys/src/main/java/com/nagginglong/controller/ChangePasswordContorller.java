package com.nagginglong.controller;

import com.nagginglong.dao.UserDao;
import com.nagginglong.entity.User;
import com.nagginglong.utils.ConstantsQantity;
import com.nagginglong.utils.Json2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * description:
 *
 * @author:像大山一样
 * @Date:2020/9/16 15:55
 */
@Controller

public class ChangePasswordContorller {
    @Autowired
    private UserDao userDao;

    @RequestMapping("/changePassword")
    @ResponseBody
    public Json2 changePassword(@RequestParam("oldPassword")String oldPassword,
                                @RequestParam("newPassword")String newPassword,
                                @RequestParam("newPassword2")String newPassword2,
                                HttpSession session){

        User user = (User)session.getAttribute(ConstantsQantity.USER_NAME);

        User uname = userDao.findUname(user.getUname());

        if (!uname.getUpassword().equals(oldPassword)) {
            return new Json2(0,"原密码输入错误",0,null);
        }

        User user1 = new User();
        user1.setUpassword(newPassword);
        user1.setUbalance(0.0);
        user1.setUimgPath(null);
        user1.setUid(user.getUid());
        userDao.update(user1);

        return new Json2(1,"修改成功!",0,null);
    }
}
