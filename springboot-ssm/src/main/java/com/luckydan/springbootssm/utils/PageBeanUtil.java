package com.luckydan.springbootssm.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Title:
 * @Description:
 * @Author: GL
 * @Date: 2021/4/1 22:20
 * @Version 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageBeanUtil {
    private Integer pageNum;
    private Integer pageSize;
}
