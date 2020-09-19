package com.nagginglong.utils;

/**
 * description:
 *
 * @author:像大山一样
 * @Date:2020/9/9 20:55
 */

public class Json2View {
    private Integer status;
    private Object info;

    public Json2View() {
    }

    public Json2View(Integer status, Object info) {
        this.status = status;
        this.info = info;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }


}
