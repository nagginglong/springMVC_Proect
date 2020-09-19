package com.nagginglong.service;

import com.nagginglong.entity.User;
import com.nagginglong.utils.Json2View;

/**
 * description:
 *
 * @author:像大山一样
 * @time:2020/9/17OrderService
 */
public interface OrderService {
    public void insertOrder(Integer cid, Double oprice, Integer uid,Integer getid,Integer backid);
    public Json2View selectOrders(Integer uid, Integer page, Integer limit);
    public  void deleteOrder(Integer id);
}
