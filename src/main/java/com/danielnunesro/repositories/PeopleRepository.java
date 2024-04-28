package com.danielnunesro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danielnunesro.entities.People;


public interface PeopleRepository extends JpaRepository<People, Long> {
	
	
	
}
