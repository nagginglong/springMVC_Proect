package com.nagginglong.entity;

import java.util.Date;

/**
 * description:
 *
 * @author:像大山一样
 * @Date:2020/9/15 8:18
 */

public class Transaction {
    private Integer tid;
    private Integer uid;
    private Integer otherUid;
    private Double money;
    private Date    createTime;
    private String comment;
    private Double  balance;
    private String consumType;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getOtherUid() {
        return otherUid;
    }

    public void setOtherUid(Integer otherUid) {
        this.otherUid = otherUid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getConsumType() {
        return consumType;
    }

    public void setConsumType(String consumType) {
        this.consumType = consumType;
    }
}
