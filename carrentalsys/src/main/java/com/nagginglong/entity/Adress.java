package com.nagginglong.entity;

/**
 * description:
 *
 * @author:像大山一样
 * @Date:2020/9/17 16:24
 */

public class Adress {
    private Integer getid1;
    private Integer getid2;
    private Integer backid1;
    private Integer backid2;

    public Adress() {
    }

    public Adress(Integer getid1, Integer getid2, Integer backid1, Integer backid2) {
        this.getid1 = getid1;
        this.getid2 = getid2;
        this.backid1 = backid1;
        this.backid2 = backid2;
    }


    public Integer getGetid1() {
        return getid1;
    }

    public void setGetid1(Integer getid1) {
        this.getid1 = getid1;
    }

    public Integer getGetid2() {
        return getid2;
    }

    public void setGetid2(Integer getid2) {
        this.getid2 = getid2;
    }

    public Integer getBackid1() {
        return backid1;
    }

    public void setBackid1(Integer backid1) {
        this.backid1 = backid1;
    }

    public Integer getBackid2() {
        return backid2;
    }

    public void setBackid2(Integer backid2) {
        this.backid2 = backid2;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "getid1=" + getid1 +
                ", getid2=" + getid2 +
                ", backid1=" + backid1 +
                ", backid2=" + backid2 +
                '}';
    }
}
