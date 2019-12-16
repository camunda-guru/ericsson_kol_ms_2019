package com.ericsson.insuranceapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ericsson.insuranceapp.models.PolicyHolder;

public interface PolicyHolderRepository extends JpaRepository<PolicyHolder,Long>{

}
