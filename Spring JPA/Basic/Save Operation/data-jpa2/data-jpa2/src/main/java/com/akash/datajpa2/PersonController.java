package com.akash.datajpa2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	
	
	@Autowired
	private PersonRepository personRepository;
	
	@RequestMapping(path = "save", method = RequestMethod.POST)
	public Person save(@RequestBody Person person) {
		personRepository.save(person);
		return person;
	}
}
