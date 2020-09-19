package com.nagginglong.dao;

import com.nagginglong.entity.Transaction;
import com.nagginglong.ov.OVTrade;
import com.nagginglong.utils.Json2View;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * description:
 *
 * @author:像大山一样
 * @time:2020/9/9TradeDao
 */


public interface TradeDao {
    public List<OVTrade> findTrade(@Param("uid") Integer uid, @Param("beginTime")Date beginTime, @Param("endTime")Date endTime);
    public void insertTransaction(Transaction transaction);
}
