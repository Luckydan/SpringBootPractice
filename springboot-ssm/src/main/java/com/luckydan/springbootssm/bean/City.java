package com.luckydan.springbootssm.bean;


import lombok.Data;

@Data
public class City {

	private Integer cityId;

	private String city;

	private Integer countryId;

	private java.util.Date lastUpdate;


}
