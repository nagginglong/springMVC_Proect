package com.nagginglong.ov;

import java.util.Date;

/**
 * description:
 *
 * @author:像大山一样
 * @Date:2020/9/9 20:34
 */

public class OVTrade {
    private Integer tid;
    private Date createTime;
    private Double pay;
    private Double income;
    private Double balance;
    private String comment;
    private String consumType;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Double getPay() {
        return pay;
    }

    public void setPay(Double pay) {
        this.pay = pay;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getConsumType() {
        return consumType;
    }

    public void setConsumType(String consumType) {
        this.consumType = consumType;
    }


    @Override
    public String toString() {
        return "OVTrade{" +
                "createTime=" + createTime +
                ", pay=" + pay +
                ", income=" + income +
                ", balance=" + balance +
                ", comment='" + comment + '\'' +
                ", consumType='" + consumType + '\'' +
                '}';
    }
}
