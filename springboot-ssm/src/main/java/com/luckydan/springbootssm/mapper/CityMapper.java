package com.luckydan.springbootssm.mapper;

import com.luckydan.springbootssm.bean.City;

import java.util.List;

/**
 * @Title:城市数据层接口
 * @Description:
 * @Author: GL
 * @Date: 2020/4/27 10:18
 * @Version 1.0.0
 */
public interface CityMapper {

    /**
     * 根据id获取城市信息
     * @return
     */
    public City getCityById(int id);

    /**
     * 根据name获取city信息
     * @param name
     * @return
     */
    public City getCityByName(String name);

    /**
     * 根据country的id,获取其下的所有city的name
     * @param id
     * @return
     */
    public List<String> getAllCityNameByCountryId(int id);
}
