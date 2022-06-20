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
import com.ty.hospitalapi.dto.ResponsStructure;
import com.ty.hospitalapi.service.BranchService;

@RestController
public class BranchControler {

	@Autowired
	BranchService branchService;
	@PostMapping("/branchs/{hid}")
	public ResponsStructure<Branch> saveBranch(@RequestBody Branch branch,@PathVariable int hid){
		return branchService.saveBranch(branch, hid);
	}
	

	@GetMapping("/branches")
	public ResponsStructure<List<Branch>> getAllBranchs(){
		return branchService.getAllBranchs();
	}
	
	@GetMapping("/branches/{id}")
	public ResponsStructure<Branch> getBranchById(@PathVariable int id){
		return branchService.getBranchById(id);
	}
	
	@PutMapping("/branches/{id}")
	public ResponsStructure<Branch> updateBranchById(@RequestBody Branch branch , @PathVariable int id){
		return branchService.updateBranchById(branch ,id);
	}
	
	@DeleteMapping("/branches/{id}")
	public ResponsStructure<String> deleteBranchById(@PathVariable int id){
		return branchService.deleteBranchById(id);
	}
}
