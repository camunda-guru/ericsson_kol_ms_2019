package com.ericsson.insuranceapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericsson.insuranceapp.models.PolicyHolder;
import com.ericsson.insuranceapp.repositories.PolicyHolderRepository;


@Service
public class PolicyHolderService {
    @Autowired
	private PolicyHolderRepository policyHolderRepository;
    
    //save
    public PolicyHolder addPolicyHolder(PolicyHolder policyHolder)
    {
    	return policyHolderRepository.save(policyHolder);
    }
    
    //findall -- select * from table
    public List<PolicyHolder> getAllPolicyHolders()
    {
    	return policyHolderRepository.findAll();
    }
    
    //find by Id where
    
    public PolicyHolder getPolicyHolderById(long adharCardNo)
    {
    	return policyHolderRepository.findById(adharCardNo).orElse(null);
    }
    
    //delete
    public boolean deletePolicyHolderById(long adharCardNo)
    {
    	boolean status=false;
    	policyHolderRepository.deleteById(adharCardNo);
    	if(getPolicyHolderById(adharCardNo)==null)
    		status=true;
    	return status;
    		
    }
    
    
}
