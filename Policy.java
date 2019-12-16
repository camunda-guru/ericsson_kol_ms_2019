package com.ericsson.insuranceapp.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="EC_Policy")
@Getter
@Setter
public class Policy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Policy_No")
	private long policyNo;
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name="From_Date")
	private LocalDate fromDate;
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name="To_Date")
	private LocalDate toDate;
	@Column(name="Insured_Sum")
	private long insuredSum;
	//association
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Policy_Holder_Identity_FK")
	private PolicyHolder policyHolder;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="Vehicle_Identity_FK")
	private Vehicle vehicle;
	

}
