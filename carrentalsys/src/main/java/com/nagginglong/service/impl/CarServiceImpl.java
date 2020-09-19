package com.nagginglong.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nagginglong.dao.CarDao;
import com.nagginglong.entity.Car;
import com.nagginglong.service.CarService;
import com.nagginglong.utils.Json2View;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description:
 *
 * @author:像大山一样
 * @Date:2020/9/17 17:29
 */
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;
    @Override
    public Json2View selectCar(Integer cid, Integer page, Integer limit) {
        // 设置每页显示的记录数，该语句紧跟数据库查询的相关语句
        PageHelper.startPage(page, limit);
        List<Car> cars = carDao.selectCar(cid);

        //总条数有关
        long total = ((Page) cars).getTotal();


        if (cars != null) {

            return  new Json2View(0,null,total,cars);

        }else{

            return  new Json2View(1,"没有查询到车辆",0,null);
        }
    }

    @Override
    public Car selectOneCar(Integer id) {

        Car car = carDao.selectOneCar(id);

        return car;
    }
}
