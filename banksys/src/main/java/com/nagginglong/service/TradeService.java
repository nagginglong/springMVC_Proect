package com.nagginglong.service;

import com.nagginglong.entity.User;
import com.nagginglong.ov.OVTrade;
import com.nagginglong.utils.Json2;
import com.nagginglong.utils.Json2View;
import jdk.nashorn.internal.ir.CallNode;

import java.util.Date;

/**
 * description:
 *
 * @author:像大山一样
 * @time:2020/9/9TradeService
 */


public interface TradeService {
    public Json2 queryTrade(Integer uid, Date beginTime, Date endTime, Integer page, Integer limit);
    public Json2View updateBalance(String uname, User user, Double money);
}
