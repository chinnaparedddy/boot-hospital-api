package com.ty.hospitalapi.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.hospitalapi.dao.BranchDao;
import com.ty.hospitalapi.dao.EncounterDao;
import com.ty.hospitalapi.dao.PersonDao;
import com.ty.hospitalapi.dto.Branch;
import com.ty.hospitalapi.dto.Encounter;
import com.ty.hospitalapi.dto.Person;
import com.ty.hospitalapi.dto.ResponsStructure;
import com.ty.hospitalapi.exception.NoIdFoundException;

@Service
public class EncounterServices {

	@Autowired
	EncounterDao encounterDao;
	@Autowired
	PersonDao personDao;
	@Autowired
	BranchDao branchDao;
	public ResponsStructure<Encounter> saveEncounter(Encounter encounter,int pid,int bid){
		ResponsStructure<Encounter> responsStructure=new ResponsStructure<Encounter>();
		Person person=personDao.getById(bid);
		if(person!=null) {
			encounter.setPerson(person);
			Branch branch=branchDao.getBranchById(bid);
			
			encounter.setAdmitDateAndTime(LocalDateTime.now());
			encounter.setDischargeDateAndTime(LocalDateTime.now());
				encounter.setBranch(branch);
				responsStructure.setStatuscode(HttpStatus.CREATED.value());
				responsStructure.setMessage("sucess");
				responsStructure.setData(encounterDao.saveEncounter(encounter));
		}else {
			throw new NoIdFoundException("Person Id not found "+pid);
		}
		return responsStructure;
	}
	public ResponsStructure<List<Encounter>> getAllEncounters() {
		List<Encounter> encounters = encounterDao.getAllEncounters();
		ResponsStructure<List<Encounter>> responseStructure = new ResponsStructure<>();
		if (encounters.size() > 0) {
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(encounters);
		} else {
			throw new NoIdFoundException("No encounters added");
		}
		return responseStructure;
	}

	public ResponsStructure<Encounter> getEncounterById(int id) {
		ResponsStructure<Encounter> responseStructure = new ResponsStructure<Encounter>();
		Encounter encounter = encounterDao.getEncounterById(id);
		if (encounter != null) {
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(encounter);
		} else {
			throw new NoIdFoundException("encounter id "+id+" Does not exist");
		}
		return responseStructure;
	}

	public ResponsStructure<Encounter> updateEncounterById(Encounter encounter, int id) {
		Encounter encounter1 = encounterDao.updateEncounterById(encounter, id);
		ResponsStructure<Encounter> responseStructure = new ResponsStructure<Encounter>();
		if (encounter1 != null) {
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(encounter1);
		} else {
			throw new NoIdFoundException("encounter id "+id+" Does not exist");
		}
		return responseStructure;
	}

	public ResponsStructure<String> deleteEncounterById(int id) {
		boolean flag = encounterDao.deleteEncounterById(id);
		ResponsStructure<String> responseStructure = new ResponsStructure<String>();
		if (flag) {
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData("Data Deleted");
		} else {
			throw new NoIdFoundException("encounter id "+id+" Does not exist");
		}
		return responseStructure;
	}
}
