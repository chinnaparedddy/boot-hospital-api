package com.ty.hospitalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.hospitalapi.dao.BranchDao;
import com.ty.hospitalapi.dao.HospitalDao;
import com.ty.hospitalapi.dto.Branch;
import com.ty.hospitalapi.dto.Hospital;
import com.ty.hospitalapi.dto.ResponsStructure;
import com.ty.hospitalapi.exception.NoIdFoundException;

@Service
public class BranchService {

	@Autowired
	BranchDao branchDao;
	@Autowired
	HospitalDao hospitalDao;
	
	public ResponsStructure<Branch> saveBranch(Branch branch,int hid){
		Hospital hospital=hospitalDao.getHospitalById(hid);
		ResponsStructure<Branch> responsStructure =new ResponsStructure<Branch>();
		if(hospital!=null) {
			branch.setHospital(hospital);
			responsStructure.setStatuscode(HttpStatus.CREATED.value());
			responsStructure.setMessage("Sucess");
			responsStructure.setData(branchDao.saveBranch(branch));
		}else {
			throw new NoIdFoundException("Hospital Id "+hid+"Not present");
		}
		return responsStructure;
	}

	public ResponsStructure<List<Branch>> getAllBranchs(){
		List<Branch> branchs = branchDao.getAllBranchs();
		ResponsStructure<List<Branch>> responseStructure = new ResponsStructure<>();
		if(branchs.size()>0) {
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(branchs);
		}else {
			throw new NoIdFoundException("No branchs added");
		}
		return responseStructure;
	}
	
	public ResponsStructure<Branch> getBranchById( int id){
		ResponsStructure<Branch> responseStructure = new ResponsStructure<Branch>();
		Branch branch = branchDao.getBranchById(id);
		if(branch!=null) {
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(branch);
		}else {
			throw new NoIdFoundException("branch id "+id+" Does not exist");
		}
		return responseStructure;
	}
	
	public ResponsStructure<Branch> updateBranchById( Branch branch ,  int id){
		Branch branch1 = branchDao.updateBranchById(branch, id);
		ResponsStructure<Branch> responseStructure = new ResponsStructure<Branch>();
		if(branch1!=null) {
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setMessage("Updated");
			responseStructure.setData(branch1);
		}else {
			throw new NoIdFoundException("branch id "+id+" Does not exist");
		}
		return responseStructure;
	}
	
	public ResponsStructure<String> deleteBranchById( int id){
		boolean flag = branchDao.deleteBranchById(id);
		ResponsStructure<String> responseStructure = new ResponsStructure<String>();
		if(flag) {
			responseStructure.setStatuscode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData("Data Deleted");
		}else {
			throw new NoIdFoundException("branch id "+id+" Does not exist");
		}
		return responseStructure;
	}
}
