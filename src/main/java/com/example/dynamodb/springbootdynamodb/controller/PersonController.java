package com.example.dynamodb.springbootdynamodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dynamodb.springbootdynamodb.entity.Person;
import com.example.dynamodb.springbootdynamodb.repository.PersonRepository;

@RestController
@RequestMapping("/persons")
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository;
	
	@PostMapping
	public Person save(@RequestBody Person person) {
		return personRepository.save(person);		
	}
	
	@GetMapping("/{id}")
	public Person findById(@PathVariable(value= "id") String id) {
		return personRepository.findById(id);
	}
	
	@GetMapping
	public List<Person> findAll(){
		return personRepository.findAll();
	}
	
	@PutMapping("/{id}")
	public String update(@PathVariable(value = "id") String id,
		@RequestBody Person person){
			return personRepository.update(id, person);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable(value = "id") String id) {
		return personRepository.delete(id);
	}

}
