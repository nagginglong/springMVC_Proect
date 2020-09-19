package com.nagginglong.controller;

import com.nagginglong.entity.User;
import com.nagginglong.service.TradeService;
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
 * @Date:2020/9/14 22:29
 */
@Controller
public class TransferController {
    @Autowired
    private TradeService tradeService;


    @RequestMapping("/transfer.do")
    @ResponseBody
    public Json2View transfer(HttpSession session, String uname, Double money){

        User user = (User)session.getAttribute(ConstantsQantity.USER_NAME);

        System.out.println("转账功能接收到的参数" + uname + money);

        Json2View j2v = tradeService.updateBalance(uname,user,money);



        return j2v;
    }



}
