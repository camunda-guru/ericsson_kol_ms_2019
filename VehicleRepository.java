package com.ericsson.insuranceapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ericsson.insuranceapp.models.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle,String>{

}
