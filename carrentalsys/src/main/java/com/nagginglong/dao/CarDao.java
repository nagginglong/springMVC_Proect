package com.nagginglong.dao;

import com.nagginglong.entity.Car;

import java.util.List;

/**
 * description:
 *
 * @author:像大山一样
 * @time:2020/9/17CarDao
 */
public interface CarDao {
    public List<Car> selectCar(Integer cid);
    public Car selectOneCar(Integer id);
    public void updateCar(Integer cid);
}
