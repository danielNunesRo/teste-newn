package com.danielnunesro.integrationtest.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.danielnunesro.entities.People;
import com.danielnunesro.repositories.PeopleRepository;

@SpringBootTest
@Transactional
public class PeopleTest {
	
	 	@Autowired
	    private PeopleRepository peopleRepository;
	 	
	 	

	    @Test
	    public void testSaveAndFindPeople() {
	        People person = new People("John", "Doe", 30);

	        peopleRepository.save(person);

	        People savedPerson = peopleRepository.findById(person.getId()).orElse(null);

	        assertNotNull(savedPerson);

	        assertEquals("John", savedPerson.getName());
	        assertEquals("Doe", savedPerson.getLastName());
	        assertEquals(30, savedPerson.getAge());
	    }
	
}
