package com.springrestapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrestapi.Model.Vehicle;

public interface VehicleRepository  extends JpaRepository<Vehicle, Integer>{

}
