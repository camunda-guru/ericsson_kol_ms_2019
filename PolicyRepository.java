package com.ericsson.insuranceapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ericsson.insuranceapp.models.Policy;

public interface PolicyRepository extends JpaRepository<Policy,Long>{

}
