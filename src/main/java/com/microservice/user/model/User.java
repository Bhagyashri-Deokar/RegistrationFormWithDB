package com.microservice.user.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NonNull;

@Data
@Entity
@Table(name="user_registration_service")
public class User 
{
	
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "user_id")
@Id
int userId;

@NotBlank(message = "User Name should not blank")
@NotEmpty(message = "User Name should not empty")
@Column(name = "user_name")
String userName;

@Column(name = "user_email")
String userEmail;

@Column(name = "user_detail")
String userDetails;

@Column(name = "phone_number")
private String phoneNumber;

@Column(name = "address")
private String address;

@Column(name = "age")
private int age;

@Column(name = "gender")
private String gender;

@Column(name = "qualification")
private String qualification;

@Column(name = "position")
private String position;
}
