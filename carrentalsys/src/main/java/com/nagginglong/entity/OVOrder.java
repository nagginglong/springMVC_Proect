package com.nagginglong.entity;

/**
 * description:
 *
 * @author:像大山一样
 * @Date:2020/9/18 8:09
 */

public class OVOrder {
    private Integer id;
    private Double oprice;
    private String name;
    private String getCar;
    private String backCar;
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getOprice() {
        return oprice;
    }

    public void setOprice(Double oprice) {
        this.oprice = oprice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGetCar() {
        return getCar;
    }

    public void setGetCar(String getCar) {
        this.getCar = getCar;
    }

    public String getBackCar() {
        return backCar;
    }

    public void setBackCar(String backCar) {
        this.backCar = backCar;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OVOrder{" +
                "id=" + id +
                ", oprice=" + oprice +
                ", name='" + name + '\'' +
                ", getCar='" + getCar + '\'' +
                ", backCar='" + backCar + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
