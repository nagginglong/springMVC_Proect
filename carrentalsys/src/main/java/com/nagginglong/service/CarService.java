package com.nagginglong.service;

import com.nagginglong.entity.Car;
import com.nagginglong.utils.Json2View;

import java.util.List;

/**
 * description:
 *
 * @author:像大山一样
 * @time:2020/9/17CarService
 */
public interface CarService {
    public Json2View selectCar(Integer cid, Integer page, Integer limit);
    public Car selectOneCar(Integer id);
}
