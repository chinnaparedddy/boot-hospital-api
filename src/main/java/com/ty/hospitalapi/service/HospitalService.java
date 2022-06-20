package com.ty.hospitalapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.hospitalapi.dao.HospitalDao;
import com.ty.hospitalapi.dto.Branch;
import com.ty.hospitalapi.dto.Hospital;
import com.ty.hospitalapi.dto.ResponsStructure;
import com.ty.hospitalapi.exception.NoIdFoundException;

@Service
public class HospitalService {

	@Autowired
	HospitalDao hospitalDao;
	
	public ResponsStructure<Hospital> saveHospital(Hospital hospital){
		ResponsStructure<Hospital> responsStructure=new ResponsStructure<Hospital>();
		responsStructure.setStatuscode(HttpStatus.CREATED.value());
		responsStructure.setMessage("sucessfully");
		responsStructure.setData(hospitalDao.saveHospital(hospital));
		return responsStructure;
	}
	public ResponsStructure<List<Hospital>> getAllHospital(){
		ResponsStructure<List<Hospital>> responsStructure=new ResponsStructure<List<Hospital>>();
		List<Hospital> hospitals=hospitalDao.getAllHospital();
		if(hospitals.isEmpty()) {
			responsStructure.setStatuscode(HttpStatus.CREATED.value());
			responsStructure.setMessage("no Hospitals");
			responsStructure.setData(null);
		}else {
			responsStructure.setStatuscode(HttpStatus.CREATED.value());
			responsStructure.setMessage("sucessfully");
			responsStructure.setData(hospitals);
		}
		return responsStructure;
	}
	public ResponsStructure<Hospital> getHospitalById(int id){
		ResponsStructure<Hospital> responsStructure=new ResponsStructure<Hospital>();
		Hospital hospital=hospitalDao.getHospitalById(id);
		if(hospital!=null) {
		responsStructure.setStatuscode(HttpStatus.NOT_FOUND.value());
		responsStructure.setMessage("Sucess");
		responsStructure.setData(hospital);
		}else {
			throw new NoIdFoundException("Id"+id+" Not Found");
		}
		return responsStructure;
	}
	public ResponsStructure<Hospital> updateHospital(Hospital hospital){
		Hospital hospital2=hospitalDao.getHospitalById(hospital.getHospital_id());
		ResponsStructure< Hospital> responsStructure=new ResponsStructure<Hospital>();
		if(hospital2!=null) {
			responsStructure.setStatuscode(HttpStatus.ACCEPTED.value());
			responsStructure.setMessage("sucess");
			responsStructure.setData(hospitalDao.updateHospital(hospital));
		}else {
			throw new NoIdFoundException("Id "+hospital.getHospital_id()+" Not Found");
		}
		return responsStructure;
	}
	public ResponsStructure<String> deleteHospital(int id){
		boolean hospital=hospitalDao.deleteHospital(id);
		ResponsStructure< String> responsStructure=new ResponsStructure<String>();
		if(hospital) {
			responsStructure.setStatuscode(HttpStatus.FOUND.value());
			responsStructure.setMessage("Sucess");
			responsStructure.setData("Deleted");
			responsStructure.setData(null);
		}else {
			throw new NoIdFoundException("Id "+id+" Not Found");
		}
		return responsStructure;
	}
}
