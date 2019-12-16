package com.ericsson.insuranceapp.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="EC_Vehicle")
@Getter
@Setter
public class Vehicle {
	@Id	
	@Column(name="Reg_No")
	private String regNo;
	@Column(name="Engine_No")
	private long engineNo;
	@Column(name="Chassis_No",nullable = false,length = 50)
	private String chassisNo;
	@Column(name="Make",nullable = false,length = 50)
	private String make;
	@Column(name="Color",nullable = false,length = 50)
	private String color;
	@DateTimeFormat(iso=ISO.DATE)
	@Column(name="Reg_Date")
	private LocalDate regDate;

	
}
