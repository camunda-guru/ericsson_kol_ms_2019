package com.ericsson.insuranceapp.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="EC_PolicyHolder")
@Getter
@Setter
public class PolicyHolder {
	@Id
	@Column(name="Adhar_CardNo")
	private long adharCardNo;
	@Column(name="First_Name",length = 50,nullable = false)
	private String firstName;
	@Column(name="Last_Name",length = 50,nullable = false)
	private String lastName;
	@Column(name="MobileNo")
	private long mobileNo;
	@Column(name="Email",length = 150,nullable = false)
	private String email;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name="DOB")
	private LocalDate dob;
	
	

}
