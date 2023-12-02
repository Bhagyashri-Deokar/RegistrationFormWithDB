package com.microservice.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "user_registration_service")
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @Id
    private int userId;

    @NotBlank(message = "Name cannot be empty. Please provide a name.")
    @NotBlank(message = "Name cannot be empty. Please provide a name.")
	@NotNull(message = "Name cannot be empty. Please provide a name.")
	@Size(min = 3, max = 100, message = "Name length should be between 3 and 100 characters")
	@Column(name = "user_name")
    private String userName;

    @NotBlank(message = "Email cannot be empty")
	@NotNull(message = "Email cannot be empty")
	@NotBlank(message = "Email cannot be empty")
	@Email(message = "Please provide a valid email address")
	 @Column(name = "user_email",unique = true)
    private String userEmail;

    @Size(max = 255, message = "User details should not exceed 255 characters")
    @Column(name = "user_detail")
    private String userDetails;

    @Size(max = 15, message = "Phone number should not exceed 10 characters")
    @Column(name = "phone_number")
    private String phoneNumber;

    @Size(max = 255, message = "Address should not exceed 255 characters")
    @Column(name = "address")
    private String address;

    @Min(value = 0, message = "Age should not be less than 0")
    @Column(name = "age")
    private int age;

    @Size(max = 10, message = "Gender should not exceed 10 characters")
    @Column(name = "gender")
    private String gender;

    @Size(max = 50, message = "Qualification should not exceed 50 characters")
    @Column(name = "qualification")
    private String qualification;

    @Size(max = 50, message = "Position should not exceed 50 characters")
    @Column(name = "position")
    private String position;
}
