package com.nagginglong.dao;

import com.nagginglong.entity.OVOrder;
import com.nagginglong.entity.Order;


import java.util.List;

/**
 * description:
 *
 * @author:像大山一样
 * @time:2020/9/17OrderDao
 */
public interface OrderDao {
    public void insertOrder(Order order);
    public List<OVOrder> selectCar(Integer uid);
    public void deleteOrder( Integer id);
}
