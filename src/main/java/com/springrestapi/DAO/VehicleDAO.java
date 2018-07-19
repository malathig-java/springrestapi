package com.springrestapi.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrestapi.Model.Vehicle;
import com.springrestapi.Repository.VehicleRepository;



@Service
public class VehicleDAO {
	
	@Autowired
	VehicleRepository vehiclerepository;
	
	// to save an vehicle
	
	public Vehicle save(Vehicle veh){
		return vehiclerepository.save(veh);
	}
	
	//search all vehicle
	
	public List<Vehicle> findAll(){
		return vehiclerepository.findAll();
	}
	//get an vehicle by ID
	public Vehicle findOne(Integer vehid){
		return vehiclerepository.findOne(vehid);
		
	}
	
	
	//delete an vehicle
	public void delete(Vehicle veh){
		vehiclerepository.delete(veh);
	}

}

