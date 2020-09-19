package com.nagginglong.dao;

import com.nagginglong.entity.City;

import java.util.List;

/**
 * description:
 *
 * @author:像大山一样
 * @time:2020/9/17CityDao
 */
public interface CityDao {
    public List<City> selectCity(Integer pid);
    public City selectName(Integer id);
}


