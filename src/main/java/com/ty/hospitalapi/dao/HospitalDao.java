package com.ty.hospitalapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospitalapi.dto.Hospital;
import com.ty.hospitalapi.repository.HospitalRepository;

@Repository
public class HospitalDao {

	@Autowired
	HospitalRepository hospitalRepository;
	public Hospital saveHospital(Hospital hospital) {
		return hospitalRepository.save(hospital);
	}
	
	public List<Hospital> getAllHospital(){
		return hospitalRepository.findAll();
	}
	public Hospital getHospitalById(int id) {
		Optional<Hospital> optional=hospitalRepository.findById(id);
		return optional.get();
	}
	public Hospital updateHospital(Hospital hospital) {
		Optional<Hospital> optional=hospitalRepository.findById(hospital.getHospital_id());
		if(optional!=null) {
			hospitalRepository.save(hospital);
			return optional.get();
		}else {
			return null;
		}
		
	}
	public boolean deleteHospital(int id) {
		Optional<Hospital> optional=hospitalRepository.findById(id);
		if(optional!=null) {
			hospitalRepository.delete(optional.get());
			return true;
		}else {
			return false;
		}
	}
}
