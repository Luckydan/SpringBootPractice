package com.luckydan.springbootssm.basic;

import java.io.Serializable;

/**
 * @author gl
 */
public class SearchFilterInfo implements Serializable
{
  private static final long serialVersionUID = -1909662537877751026L;

  /**
   * 显示的字段名称
   */
  private String fieldName;

  /**
   * "比较字段,目前支持 =,>,<,!=,>=,<=,in"
   */
  private String compare;

  /**
   * 字段值, 如果是in,用逗号隔开
   */

  private String fieldValue;

  /**
   * 字段类型
   */
  private String fieldType;

  public SearchFilterInfo(String fieldName, String compare, String fieldValue, String fieldType) {
    this.fieldName = fieldName;
    this.compare = compare;
    this.fieldValue = fieldValue;
    this.fieldType = fieldType;
  }

  public String getFieldName() {
    return fieldName;
  }

  public String getCompare() {
    return compare;
  }

  public String getFieldValue() {
    return fieldValue;
  }

  public String getFieldType() {
    return fieldType;
  }


  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }


  public void setCompare(String compare) {
    this.compare = compare;
  }


  public void setFieldValue(String fieldValue) {
    this.fieldValue = fieldValue;
  }


  public void setFieldType(String fieldType) {
    this.fieldType = fieldType;
  }

  @Override
  public String toString() {
    return "SearchFilterInfo{" +
            "fieldName='" + fieldName + '\'' +
            ", compare='" + compare + '\'' +
            ", fieldValue='" + fieldValue + '\'' +
            ", fieldType='" + fieldType + '\'' +
            '}';
  }
}