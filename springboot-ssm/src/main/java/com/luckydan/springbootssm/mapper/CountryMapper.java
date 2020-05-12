package com.luckydan.springbootssm.mapper;

import com.luckydan.springbootssm.bean.Country;

/**
 * @Title:
 * @Description:
 * @Author: GL
 * @Date: 2020/4/27 10:24
 * @Version 1.0.0
 */
public interface CountryMapper {

    /**
     * 根据id获取Country信息
     * @param id
     * @return
     */
    public Country getCountryById(int id);

    /**
     * 根据name获取Country信息
     * @param name
     * @return
     */
    public Country getCountryByName(String name);
}
