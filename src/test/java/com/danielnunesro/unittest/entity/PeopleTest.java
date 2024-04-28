package com.danielnunesro.unittest.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.danielnunesro.entities.People;


public class PeopleTest {
	
	@Test
    public void testGettersAndSetters() {
        People person = new People();
        
        person.setId(1L);
        person.setName("John");
        person.setLastName("Doe");
        person.setAge(30);

        assertEquals(1L, person.getId());
        assertEquals("John", person.getName());
        assertEquals("Doe", person.getLastName());
        assertEquals(30, person.getAge());
    }
	
}
