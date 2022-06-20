package com.ty.hospitalapi.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.hospitalapi.dto.Person;
import com.ty.hospitalapi.dto.ResponsStructure;
import com.ty.hospitalapi.service.PersonService;

@RestController
public class PersonControler {

	@Autowired
	PersonService personService;
	@PostMapping("/persons")
	public ResponsStructure<Person> savePerson(@RequestBody Person person){
		return personService.savePerson(person);
	}
	@GetMapping("/persons")
	public ResponsStructure<List<Person>> getAllPerson(){
		return personService.getAllPersons();
	}
	@GetMapping("/persons/{id}")
	public ResponsStructure<Person> personGetById(@PathVariable int id){
		return personService.getById(id);
	}
	@PutMapping("/persons")
	public ResponsStructure<Person> updatePerson(@RequestBody Person person){
		return personService.updatePerson(person);
	}
	
	@DeleteMapping("/persons/{id}")
	public ResponsStructure<String> deletePerson(@PathVariable int id){
		return personService.deletePerson(id);
	}
}
