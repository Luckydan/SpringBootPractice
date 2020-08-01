package com.luckydan.springbootssm.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.luckydan.springbootssm.basic.SearchFilterInfo;
import com.luckydan.springbootssm.basic.SearchParams;
import com.luckydan.springbootssm.bean.Address;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Title: 地址信息数据层接口
 * @Description:
 * @Author: GL
 * @Date: 2020/4/27 10:00
 * @Version 1.0.0
 */
@Service
public interface AddressMapper {

    /**
     * 获取所有的地址信息
     */
    public List<Address>  getAllAddress();

    /**
     * 根据address的id获取指定的address信息
     * @param id
     * @return
     */
    public Address getAddressById(int id);

    /**
     * 通过多个id获取对应的address信息
     * @param ids
     * @return
     */
    public List<Address> getAddressByids(String fields,String fieldName,String compare, List<String> ids);

    /**
     * 自定义条件查询 ----以过滤字段信息作为条件查询Address
     * @param searchFilterInfo
     * @return
     */
    public List<Address> getAddressByCustomerCondition(SearchFilterInfo searchFilterInfo);

    /**
     *
     * @param field
     * @return
     */
    public List<Map<String, Object>>  getGoupbyField(String field);

    /**
     * 自定义字段列表和条件查询 ----以过滤字段信息作为条件，SearchParams中的fields字段作为需要查找的字段列表
     * @param
     * @return
     */
    public List<Address> getAddressCustomeFieldsByCustomerCondition(String fields,String fieldName,String compare,String fieldValue);

    /**
     * 通过city_id 进行分页查询
     * @param page
     * @param city_id
     * @return
     */
    public IPage getAddressByPage(Page page, Integer city_id);
}
