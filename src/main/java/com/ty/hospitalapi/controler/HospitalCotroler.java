package com.ty.hospitalapi.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospitalapi.dto.Branch;
import com.ty.hospitalapi.dto.Hospital;
import com.ty.hospitalapi.dto.ResponsStructure;
import com.ty.hospitalapi.service.HospitalService;

@RestController
public class HospitalCotroler {

	@Autowired
	HospitalService hospitalService;
	
	@PostMapping("/hospitals")
	public ResponsStructure<Hospital> saveHospital(@RequestBody Hospital hospital){
		return hospitalService.saveHospital(hospital);
	}

	
	@GetMapping("/hospitals")
	public ResponsStructure<List<Hospital>> getAllHospitals(){
		return hospitalService.getAllHospital();
	}
	
	@GetMapping("/hospitals/{id}")
	public ResponsStructure<Hospital> getHospitalById(@PathVariable int id){
		return hospitalService.getHospitalById(id);
	}
	
	@PutMapping("/hospitals")
	public ResponsStructure<Hospital> updateHospitalById(@RequestBody Hospital hospital ){
		return hospitalService.updateHospital(hospital);
	}
	
	@DeleteMapping("/hospitals/{id}")
	public ResponsStructure<String> deleteHospitalById(@PathVariable int id){
		return hospitalService.deleteHospital(id);
	}
}
