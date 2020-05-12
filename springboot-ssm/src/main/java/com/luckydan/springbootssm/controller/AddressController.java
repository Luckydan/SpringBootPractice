package com.luckydan.springbootssm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.luckydan.springbootssm.basic.BaseApiService;
import com.luckydan.springbootssm.basic.BaseResponse;
import com.luckydan.springbootssm.basic.SearchFilterInfo;
import com.luckydan.springbootssm.basic.SearchParams;
import com.luckydan.springbootssm.bean.Address;
import com.luckydan.springbootssm.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.codec.AbstractDataBufferDecoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Title:
 * @Description:
 * @Author: GL
 * @Date: 2020/4/27 11:55
 * @Version 1.0.0
 */
@Controller
public class AddressController extends BaseApiService<Address> {
    @Autowired
    private AddressMapper addressMapper;

    @ResponseBody
    @RequestMapping("/getAddress/{id}")
    public BaseResponse<Address> getAddressById(@PathVariable Integer id){
        Address address = addressMapper.getAddressById(id);
        return setResult(200,"success",address);
    }

    @ResponseBody
    @RequestMapping(value = "/getMutiAddressByMutiId",method = RequestMethod.POST)
    public BaseResponse<List<Address>> getAddressByMutiIds(@RequestBody SearchParams params){
        String fields = params.getFields();
        String fieldName = params.getFilters().get(0).getFieldName();
        String compare = params.getFilters().get(0).getCompare();
        List<String> ids = Arrays.asList(params.getFilters().get(0).getFieldValue().split(","));
        List<Address> addressByids = addressMapper.getAddressByids(fields, fieldName, compare, ids);
        return setMutiResult(200,"success",addressByids);
    }

    @ResponseBody
    @RequestMapping(value="/getAddressByCustomerCondition",method = RequestMethod.POST)
    public BaseResponse<List<Address>> getAddressByCustomerCondition(@RequestBody SearchParams params){
        if(params == null || params.getFilters() == null){
            setResultError("参数不能为空 及 Filter不能为空");
        }
        SearchFilterInfo searchFilterInfo = params.getFilters().get(0);
        List<Address> address = addressMapper.getAddressByCustomerCondition(searchFilterInfo);
        return setMutiResult(200,"Success",address);
    }

    @ResponseBody
    @RequestMapping(value="/getAddressCustomeFieldsByCustomerCondition",method = RequestMethod.POST)
    public BaseResponse<List<Address>> getAddressCustomeFieldsByCustomerCondition(@RequestBody SearchParams params){
        if(params == null || params.getFilters() == null){
            setResultError("参数不能为空 及 Filter不能为空");
        }
        SearchFilterInfo searchFilterInfo = params.getFilters().get(0);
        List<Address> address = addressMapper.getAddressCustomeFieldsByCustomerCondition(params.getFields(),
                searchFilterInfo.getFieldName(),searchFilterInfo.getCompare(),
                searchFilterInfo.getFieldValue());
        return setMutiResult(200,"Success",address);
    }

    @ResponseBody
    @RequestMapping("/getGroupByField")
    public String getGroupByField(String field){
        List<Map<String, Object>> goupbyField = addressMapper.getGoupbyField(field);
        return JSON.toJSONString(goupbyField);
    }

}
