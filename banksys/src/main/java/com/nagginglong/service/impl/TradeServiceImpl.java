package com.nagginglong.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nagginglong.dao.TradeDao;
import com.nagginglong.dao.UserDao;
import com.nagginglong.entity.Transaction;
import com.nagginglong.entity.User;
import com.nagginglong.ov.OVTrade;
import com.nagginglong.service.TradeService;
import com.nagginglong.utils.Json2;
import com.nagginglong.utils.Json2View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * description:
 *
 * @author:像大山一样
 * @Date:2020/9/9 20:36
 */
@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    private TradeDao tradeDao;
    @Autowired
    private UserDao userDao;

    private Json2View json2View ;

    public Json2 queryTrade(Integer uid, Date beginTime, Date endTime,Integer page, Integer limit) {

        // 设置每页显示的记录数，该语句紧跟数据库查询的相关语句
        PageHelper.startPage(page, limit);
        List<OVTrade> tradelist = tradeDao.findTrade(uid,beginTime,endTime);

        //总条数有关
        long total = ((Page) tradelist).getTotal();


        if (tradelist != null) {

            return  new Json2(0,null,total,tradelist);

        }else{

            return  new Json2(1,"没有转账记录",0,null);
        }



    }

    @Override
    public Json2View updateBalance(String uname, User user, Double money) {
        //1.判断
        //判断用户是否为空
        if (user.getUname() == null) {
            throw new RuntimeException("账户还未登录！");
        }
        //判断对方账户是否为空
        if (uname == null) {
            throw new RuntimeException("转账账户不能为空！");
        }
        //判断转账金额
        if (money <= 0 ){
            throw new RuntimeException("转账金额必须大于0！");
        }
        if (user.getUbalance() < money){
            throw new RuntimeException("账户余额不足！");
        }
        //判断对方账户
        User otherName = userDao.findUname(uname);
        if (otherName == null) {
            throw new RuntimeException("转账账户不存在！");
        }

        //2.执行SQL语句
        //订单表添加两条信息
        Transaction transaction = new Transaction();

        //添加登录账户的信息
        transaction.setUid(user.getUid());
        transaction.setOtherUid(otherName.getUid());
        transaction.setBalance(user.getUbalance() - money);
        transaction.setCreateTime(new Date());
        transaction.setMoney(0-money);
        transaction.setConsumType("pay");
        transaction.setComment("支付大保健金额");

        tradeDao.insertTransaction(transaction);

        //添加转账账户的信息
        Transaction transaction1 = new Transaction();
        transaction1.setUid(otherName.getUid());
        transaction1.setOtherUid(user.getUid());
        transaction1.setBalance(otherName.getUbalance() + money);
        transaction1.setCreateTime(new Date());
        transaction1.setMoney(money);
        transaction1.setConsumType("income");
        transaction1.setComment("搬砖挣钱");

        tradeDao.insertTransaction(transaction1);



        //户用表修改信息
        //修改当前登录用户的信息！
        User user1 = new User();
        user1.setUbalance(user.getUbalance() - money);
        user1.setUid(user.getUid());
        userDao.update(user1);

        //修改转账用户的信息！
        User user2 = new User();
        user2.setUbalance(otherName.getUbalance() + money);
        user2.setUid(otherName.getUid());
        userDao.update(user2);







        return new Json2View(1,"转账成功！");
    }
}
