package com.ty.hospitalapi.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.hospitalapi.dto.Person;
import com.ty.hospitalapi.dto.User;
import com.ty.hospitalapi.repository.PersonRepository;

@Repository
public class PersonDao {

	@Autowired
	private PersonRepository personRepository;
	
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}
	public List<Person> getAllPersons(){
		return personRepository.findAll();
	}
	public Person getById(int id) {
		Optional<Person> optional=personRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	public Person updatePerson(Person person) {
		Optional<Person> optional=personRepository.findById(person.getId());
		if(optional.isPresent()) {
			personRepository.save(person);
			return person;
		}else {
			return null;
		}
	}
	public boolean deletePerson(int id) {
		Optional<Person> optional=personRepository.findById(id);
		if(optional.isPresent()) {
			personRepository.delete(optional.get());
			return true;
		}else {
			return false;
		}
	}
}
