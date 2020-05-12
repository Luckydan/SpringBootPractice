package com.luckydan.springbootssm.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	private Integer addressId;

	private String address;

	private String address2;

	private String district;

	private Integer cityId;

	private String postalCode;

	private String phone;

	private java.util.Date lastUpdate;


}
