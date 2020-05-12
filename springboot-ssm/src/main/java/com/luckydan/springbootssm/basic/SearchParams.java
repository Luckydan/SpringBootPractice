package com.luckydan.springbootssm.basic;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @Title:
 * @Description:
 * @Author: GL
 * @Date: 2020/4/30 15:09
 * @Version 1.0.0
 */
public class SearchParams implements Serializable {

    /**
     * 返回字段值列表，逗号隔开，不指定默认所有
     */
    private String fields;

    /**
     * 过滤条件列表
     */
    private List<SearchFilterInfo> filters;

    /**
     * 排序字段，ex:name asc, name desc
     */
    private String orderBy;

    /**
     * 分页页码
     */
    private int page;

    /**
     * 每页条数
     */
    private int parPage;

    public SearchParams(String fields, List<SearchFilterInfo> filters, String orderBy, int page, int parPage) {
        this.fields = fields;
        this.filters = filters;
        this.orderBy = orderBy;
        this.page = page;
        this.parPage = parPage;
    }

    public String getFields() {
        return fields;
    }

    public List<SearchFilterInfo> getFilters() {
        return filters;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public int getPage() {
        return page;
    }

    public int getParPage() {
        return parPage;
    }


    public void setFields(String fields) {
        this.fields = fields;
    }


    public void setFilters(List<SearchFilterInfo> filters) {
        this.filters = filters;
    }


    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }


    public void setPage(int page) {
        this.page = page;
    }

    public void setParPage(int parPage) {
        this.parPage = parPage;
    }

    @Override
    public String toString() {
        return "SearchParams{" +
                "fields='" + fields + '\'' +
                ", filters=" + filters +
                ", orderBy='" + orderBy + '\'' +
                ", page=" + page +
                ", parPage=" + parPage +
                '}';
    }
}
