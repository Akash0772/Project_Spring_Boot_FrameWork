package com.akash.datajpa4;




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
	
	@RequestMapping(path = "savePersons", method = RequestMethod.POST)
	public String savePersons(@RequestBody AllPersons allPersons) {
		personRepository.saveAll(allPersons.getPersons());
		return "success";
	}
	
	
	@RequestMapping(path = "update", method = RequestMethod.PUT)
	public Person update(@RequestBody Person person) {
		personRepository.save(person);
		return person;
	}
	
	@RequestMapping(path = "patch", method = RequestMethod.PATCH)
	public Person patching(@RequestBody Person person) {
		Person dbPerson = personRepository.findById(person.getId()).get();
		if(person.getFirstName() != null) {
			dbPerson.setFirstName(person.getFirstName());
		}
		if(person.getLastName() != null) {
			dbPerson.setLastName(person.getLastName());
		}
		personRepository.save(dbPerson);
		return dbPerson;
	}
}
