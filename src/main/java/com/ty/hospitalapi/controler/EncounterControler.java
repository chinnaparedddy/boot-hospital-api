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

import com.ty.hospitalapi.dto.Encounter;
import com.ty.hospitalapi.dto.ResponsStructure;
import com.ty.hospitalapi.service.EncounterServices;

@RestController
public class EncounterControler {

	@Autowired
	EncounterServices encounterServices;
	
	@PostMapping("/encounters/{pid}/{bid}")
	public ResponsStructure<Encounter> saveEncounter(@RequestBody Encounter encounter,@PathVariable int pid,@PathVariable int bid){
		return encounterServices.saveEncounter(encounter, pid, bid);
	}

	@GetMapping("/encounters")
	public ResponsStructure<List<Encounter>> getAllEncounters(){
		return encounterServices.getAllEncounters();
	}
	
	@GetMapping("/encounters/{id}")
	public ResponsStructure<Encounter> getEncounterById(@PathVariable int id){
		return encounterServices.getEncounterById(id);
	}
	
	@PutMapping("/encounters/{id}")
	public ResponsStructure<Encounter> updateEncounterById(@RequestBody Encounter encounter , @PathVariable int id){
		return encounterServices.updateEncounterById(encounter ,id);
	}
	
	@DeleteMapping("/encounters/{id}")
	public ResponsStructure<String> deleteEncounterById(@PathVariable int id){
		return encounterServices.deleteEncounterById(id);
	}
}
