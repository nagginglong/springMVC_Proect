package com.nagginglong.entity;

/**
 * description:
 *
 * @author:像大山一样
 * @Date:2020/9/17 8:08
 */

public class Order {
    private Integer id;
    private Integer cid;
    private Integer uid;
    private Integer getid;
    private Integer backid;
    private Double oprice;
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getGetid() {
        return getid;
    }

    public void setGetid(Integer getid) {
        this.getid = getid;
    }

    public Integer getBackid() {
        return backid;
    }

    public void setBackid(Integer backid) {
        this.backid = backid;
    }

    public Double getOprice() {
        return oprice;
    }

    public void setOprice(Double oprice) {
        this.oprice = oprice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", cid=" + cid +
                ", uid=" + uid +
                ", getid=" + getid +
                ", backid=" + backid +
                ", oprice=" + oprice +
                ", status='" + status + '\'' +
                '}';
    }
}
