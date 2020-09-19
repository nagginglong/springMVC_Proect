package com.nagginglong.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nagginglong.dao.CarDao;
import com.nagginglong.dao.OrderDao;
import com.nagginglong.entity.Car;
import com.nagginglong.entity.OVOrder;
import com.nagginglong.entity.Order;
import com.nagginglong.entity.User;
import com.nagginglong.service.OrderService;
import com.nagginglong.utils.Json2View;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description:
 *
 * @author:像大山一样
 * @Date:2020/9/17 19:28
 */

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private CarDao carDao;

    @Override
    public void insertOrder(Integer cid, Double oprice, Integer uid, Integer getid, Integer backid) {

        carDao.updateCar(cid);

        Order order = new Order();
        order.setCid(cid);
        order.setUid(uid);
        order.setGetid(getid);
        order.setBackid(backid);
        order.setOprice(oprice);
        order.setStatus("已预定");

        orderDao.insertOrder(order);



    }

    @Override
    public Json2View selectOrders(Integer uid, Integer page, Integer limit) {
        // 设置每页显示的记录数，该语句紧跟数据库查询的相关语句
        PageHelper.startPage(page, limit);
        List<OVOrder> ovorders = orderDao.selectCar(uid);

        //总条数有关
        long total = ((Page) ovorders).getTotal();


        if (ovorders != null) {

            return  new Json2View(0,null,total,ovorders);

        }else{

            return  new Json2View(1,"没有查询到订单信息",0,null);
        }

    }

    @Override
    public void deleteOrder(Integer id) {
        orderDao.deleteOrder(id);
    }
}
