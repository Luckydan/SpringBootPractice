package com.luckydan.springbootssm.bean;


import lombok.Data;

@Data
public class Customer {

	private Integer customerId;

	private Integer storeId;

	private String firstName;

	private String lastName;

	private String email;

	private Integer addressId;

	private Integer active;

	private java.util.Date createDate;

	private java.util.Date lastUpdate;


}
