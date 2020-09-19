package com.nagginglong.controller;

import com.nagginglong.entity.Adress;
import com.nagginglong.entity.User;
import com.nagginglong.service.OrderService;
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
 * @Date:2020/9/17 19:24
 */

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/addCar.do")
    @ResponseBody
    public Json2View addCar(Integer id, Double oprice, HttpSession session){

        Adress adress = (Adress)session.getAttribute(ConstantsQantity.ADRESS);
        User user = (User)session.getAttribute(ConstantsQantity.USER_NAME);


        orderService.insertOrder(id,oprice,user.getId(),adress.getGetid2(),adress.getBackid2());

        return new Json2View(1,"下单成功！",0,null);
    }


    @RequestMapping("/selectOrder.do")
    @ResponseBody
    public Json2View selectOrder(HttpSession session,Integer page,Integer limit){
        User user =(User) session.getAttribute(ConstantsQantity.USER_NAME);

        Json2View json2View = orderService.selectOrders(user.getId(), page, limit);


        return json2View;
    }

    @RequestMapping("/deleteOrder.do")
    @ResponseBody
    public Json2View deleteOrder(Integer id){

        orderService.deleteOrder(id);

        return new Json2View(1,"删除成功！",0,null);
    }
}
