package com.danielnunesro.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danielnunesro.entities.People;


public interface PeopleRepository extends JpaRepository<People, Long> {
	
	List<People> findByName(String name);
	
}
