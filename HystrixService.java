package com.virtusa.virtusahystrixdashboard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.virtusa.virtusahystrixdashboard.models.Beneficiary;

@Service
public class HystrixService {
    @Autowired
	private RestTemplate restTemplate;
	
    @HystrixCommand(fallbackMethod = "handleFallBack")
    public String handleRequest(Beneficiary beneficiary)
    {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
    	HttpEntity<Beneficiary> request = new HttpEntity<Beneficiary>(beneficiary, headers);
        //rabbitmq
    	return restTemplate.exchange("http://localhost:8081/addbeneficiary", 
    			HttpMethod.POST, request, 
				new ParameterizedTypeReference<String>() {
        }).getBody();
    }
    
    
    public String handleFallBack(Beneficiary beneficiary)
    {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
    	HttpEntity<Beneficiary> request = new HttpEntity<Beneficiary>(beneficiary, headers);
    	//kafka
    	return restTemplate.exchange("http://localhost:7070/addBeneficiary", 
    			HttpMethod.POST, request, 
				new ParameterizedTypeReference<String>() {
        }).getBody();
    }
	
	
}
