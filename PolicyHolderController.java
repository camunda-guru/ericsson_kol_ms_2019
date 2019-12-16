package com.ericsson.insuranceapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ericsson.insuranceapp.models.PolicyHolder;
import com.ericsson.insuranceapp.services.PolicyHolderService;

@RestController
public class PolicyHolderController {
	@Autowired
	private PolicyHolderService policyHolderService;
	//save
	@CrossOrigin("*")
	@PostMapping("/addpolicyholder")
	public @ResponseBody PolicyHolder addPolicyHolder(@RequestBody PolicyHolder policyHolder)
	{
		return policyHolderService.addPolicyHolder(policyHolder);
		
	}
	
	//findall
	@CrossOrigin("*")
	@GetMapping("/getallpolicyholders")
	public List<PolicyHolder> getAllPolicyHolders()
	{
		return policyHolderService.getAllPolicyHolders();
		
	}
	
	//find by id
	@CrossOrigin("*")
	@GetMapping("/getpolicyhlderbyid/{id}")
	public PolicyHolder getPolicyHolderById(@PathVariable("id") long adharCardNo)
	{
		return policyHolderService.getPolicyHolderById(adharCardNo);
	}
	
	//delete by id
	@CrossOrigin("*")
	@GetMapping("/deletepolicyhlderbyid/{id}")
	public boolean deletePolicyHolderById(@PathVariable("id") long adharCardNo)
	{
		return policyHolderService.deletePolicyHolderById(adharCardNo);
	}

}
