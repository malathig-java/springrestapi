package com.springrestapi.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrestapi.DAO.VehicleDAO;
import com.springrestapi.Model.Vehicle;

@RestController
@RequestMapping("/company")
public class VehicleController {

	@Autowired
	VehicleDAO vehicleDAO;
	
	//to save an vehicle
	@PostMapping("/vehicle")
	public Vehicle createVehicle(@Valid @RequestBody Vehicle veh){
		return vehicleDAO.save(veh);
	}
    //get all vehicles
		@GetMapping("/vehicles")
		public List<Vehicle> getAllVehicles(){
			return vehicleDAO.findAll();
		}
	//get vehicle by vehID
		@GetMapping("/vehicles/{id}")
		public ResponseEntity<Vehicle> getVehicleById(@PathVariable(value="id") Integer vehid){
			Vehicle veh= vehicleDAO.findOne(vehid);
			if(veh==null){
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok().body(veh);
		}
		
		//Update an vehicle by VehID
		@PutMapping("/vehicles/{id}")
		public ResponseEntity<Vehicle> updateEmployee(@PathVariable(value="id") Integer empid,@Valid @RequestBody Vehicle vehDetails){
			Vehicle veh= vehicleDAO.findOne(empid);
			if(veh==null){
				return ResponseEntity.notFound().build();
			}
			veh.setType(vehDetails.getType());
			veh.setColor(vehDetails.getColor());
			veh.setCost(vehDetails.getCost());
			
			
			Vehicle updateVehicle =vehicleDAO.save(veh);
			return ResponseEntity.ok().body(updateVehicle);
		}
		
		//Delete an vehicle
		@DeleteMapping("/vehicles/{id}")
		public ResponseEntity<Vehicle> deleteEmployee(@PathVariable(value="id") Integer vehid){
			Vehicle veh= vehicleDAO.findOne(vehid);
			if(veh==null){
				return ResponseEntity.notFound().build();
			}
		vehicleDAO.delete(veh);
			return ResponseEntity.ok().build();
		}
}
