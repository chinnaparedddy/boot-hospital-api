package com.ty.hospitalapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.hospitalapi.dao.PersonDao;
import com.ty.hospitalapi.dto.Person;
import com.ty.hospitalapi.dto.ResponsStructure;

@Service
public class PersonService {


	@Autowired
	private PersonDao personDao;
	public ResponsStructure<Person> savePerson(Person person){
		ResponsStructure<Person> responsStructure=new ResponsStructure<Person>();
		responsStructure.setStatuscode(HttpStatus.CREATED.value());
		responsStructure.setMessage("Sucess");
		responsStructure.setData(personDao.savePerson(person));
		return responsStructure;
	}
	public ResponsStructure<List<Person>>  getAllPersons(){
		
		ResponsStructure<List<Person>> responsStructure=new ResponsStructure<List<Person>>();
		responsStructure.setStatuscode(HttpStatus.CREATED.value());
		responsStructure.setMessage("Sucess");
		responsStructure.setData(personDao.getAllPersons());
		return responsStructure;
	}
	public ResponsStructure<Person> getById(int id){
		Person person=personDao.getById(id);
		ResponsStructure<Person> responsStructure=new ResponsStructure<Person>();
		if(person!=null) {
		responsStructure.setStatuscode(HttpStatus.CREATED.value());
		responsStructure.setMessage("Sucess");
		responsStructure.setData(person);
		}else {
			responsStructure.setStatuscode(HttpStatus.CREATED.value());
			responsStructure.setMessage("Sucess");
			responsStructure.setData(person);
		}
		return responsStructure;
	}
	public ResponsStructure<Person> updatePerson(Person person){
		Person person1=personDao.getById(person.getId());
		ResponsStructure<Person> responsStructure=new ResponsStructure<Person>();
		if(person1!=null) {
		responsStructure.setStatuscode(HttpStatus.CREATED.value());
		responsStructure.setMessage("Sucess");
		responsStructure.setData(personDao.updatePerson(person));
		}else {
			responsStructure.setStatuscode(HttpStatus.CREATED.value());
			responsStructure.setMessage("Id Not Found");
			responsStructure.setData(person);
		}
		return responsStructure;
	}
	public ResponsStructure<String> deletePerson(int id){
		boolean flag=personDao.deletePerson(id);
		ResponsStructure<String> responsStructure=new ResponsStructure<String>();
		if(flag) {
			responsStructure.setStatuscode(HttpStatus.CREATED.value());
			responsStructure.setMessage("Deleted");
			responsStructure.setData("Data Deleted");
		}else {
			responsStructure.setStatuscode(HttpStatus.CREATED.value());
			responsStructure.setMessage("Not Deleted");
			responsStructure.setData("Data not Deleted");
		}
		return responsStructure;
	}
}
