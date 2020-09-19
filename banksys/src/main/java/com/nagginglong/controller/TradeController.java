package com.nagginglong.controller;

import com.nagginglong.entity.User;
import com.nagginglong.service.TradeService;
import com.nagginglong.utils.ConstantsQantity;
import com.nagginglong.utils.Json2;
import com.nagginglong.utils.Json2View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * description:
 *
 * @author:像大山一样
 * @Date:2020/9/9 20:32
 */
@Controller
public class TradeController {

    @Autowired
    private TradeService tradeService;


    @RequestMapping("/trade.do")
    @ResponseBody
    public Json2 queryTrade(HttpSession session,Date beginTime, Date endTime,Integer page, Integer limit){

        System.out.println(endTime +"--------查询转账记录---------" +beginTime);

        User user = (User)session.getAttribute(ConstantsQantity.USER_NAME);


        Json2 json2 = tradeService.queryTrade(user.getUid(),beginTime,endTime,page,limit);



        return json2 ;




    }
}
