package com.akash.jpa1;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Person {
	
	@Id
	private Integer person_Id;
	private String firstName;
	private String lastName;
}
