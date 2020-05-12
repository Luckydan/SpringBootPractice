package com.luckydan.springbootssm.mapper;

import com.luckydan.springbootssm.bean.Customer;
import org.javatuples.Quartet;

/**
 * @Title:
 * @Description:
 * @Author: GL
 * @Date: 2020/4/27 10:29
 * @Version 1.0.0
 */
public interface CustomerMapper {
    /**
     * 根据id获取Customer信息
     * @param id
     * @return
     */
    public Customer getCustomerById(int id);

    /**
     * 根据name获取Customer信息
     * @param firstName
     * @param secondName
     * @return
     */
    public Customer getCustomerByName(String firstName,String secondName);

    /**
     * 根据email获取Customer信息
     * @param email
     * @return
     */
    public Customer getCustomerByEmail(String email);

    /**
     * 根据用户id获取customer的详细地址信息
     * @param id
     * @return
     */
    public Quartet<String,String,String,String> getCustomerAddressBy(int id);
}
