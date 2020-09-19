package com.nagginglong.service.impl;

import com.nagginglong.dao.CityDao;
import com.nagginglong.entity.City;
import com.nagginglong.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description:
 *
 * @author:像大山一样
 * @Date:2020/9/17 14:36
 */

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDao cityDao;


    @Override
    public List<City> selectCity(Integer pid) {

        List<City> list = cityDao.selectCity(pid);

        if (list == null | list.size() <= 0) {

            throw new RuntimeException("查询失败！");

        }

        return list;
    }

    @Override
    public City selectName(Integer id) {

        City city = cityDao.selectName(id);

        return city;
    }
}
