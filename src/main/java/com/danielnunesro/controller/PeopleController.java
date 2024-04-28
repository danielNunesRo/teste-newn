package com.danielnunesro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danielnunesro.entities.People;
import com.danielnunesro.services.PeopleService;

@RestController
@RequestMapping("/api")
public class PeopleController {
	
	@Autowired
	private PeopleService service;
	
	@PostMapping
	public ResponseEntity<People> create(@RequestBody People people) {
		service.create(people);
		return ResponseEntity.status(HttpStatus.CREATED).body(people);
	}
	
	@GetMapping
	public ResponseEntity<List<People>> findAll() {
		List<People> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/people/{id}")
	public ResponseEntity<People> findById(@PathVariable Long id) {
		People people = service.findById(id);
		return ResponseEntity.ok().body(people);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<List<People>> findByName(@PathVariable String name) {
		List<People> list = service.findByName(name);
		return ResponseEntity.ok().body(list);
	}
		
	
	
	
	
	
}
