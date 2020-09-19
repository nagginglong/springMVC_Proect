package com.nagginglong.entity;

/**
 * description:
 *
 * @author:像大山一样
 * @Date:2020/9/9 20:34
 */

public class User {
    private Integer uid;
    private String uname;
    private String upassword;
    private double ubalance;
    private String uimgPath;


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public double getUbalance() {
        return ubalance;
    }

    public void setUbalance(double ubalance) {
        this.ubalance = ubalance;
    }

    public String getUimgPath() {
        return uimgPath;
    }

    public void setUimgPath(String uimgPath) {
        this.uimgPath = uimgPath;
    }

    @Override
    public String toString() {
        return "UserDaoImpl{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upassword='" + upassword + '\'' +
                ", ubalance=" + ubalance +
                '}';
    }
}
