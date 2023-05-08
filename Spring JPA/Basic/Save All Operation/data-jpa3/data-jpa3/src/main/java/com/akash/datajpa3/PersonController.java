package com.akash.datajpa3;

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
	public Person person(@RequestBody Person person) {
		personRepository.save(person);
		return person;
	}
	
	@RequestMapping(path = "savePersons", method = RequestMethod.POST)
	public String savePersons(@RequestBody AllPersons allPersons) {
		personRepository.saveAll(allPersons.getPersons());
		return "success";
	}
}
