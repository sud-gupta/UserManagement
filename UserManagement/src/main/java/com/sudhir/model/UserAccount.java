package com.sudhir.model;

import java.util.Date;

import lombok.Data;

@Data
public class UserAccount {
	private Integer userId;
	private String firstName;
	private String lastName;
	private String email;
	private Integer phno;
	private Date dob;
	private String gender;
	private Integer countryId;
	private Integer stateId;
	private Integer cityId;
	private String password;
	private String status;
	
}
