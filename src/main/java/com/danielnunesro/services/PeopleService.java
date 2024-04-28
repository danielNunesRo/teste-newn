package com.danielnunesro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielnunesro.entities.People;
import com.danielnunesro.repositories.PeopleRepository;

@Service
public class PeopleService {
	
	@Autowired
	private PeopleRepository repository;
	
	public List<People> findAll() {
		return repository.findAll();
	}
	
	public People findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Nenhum usuário encontrado"));
	}
	
	public List<People> findByName(String name){
		return repository.findByName(name);
	}
	
	public People create(People people) {
		return repository.save(people);
	}
	
	public People update(People people) {
		if (people.getId() == null) {
	        throw new IllegalArgumentException("O ID da pessoa não pode ser nulo para atualização");
	    }
	    
	    People existingPerson = repository.findById(people.getId())
	            .orElseThrow(() -> new RuntimeException("Pessoa não encontrada para atualização"));
	    
	    existingPerson.setName(people.getName());
	    existingPerson.setLastName(people.getLastName());
	    existingPerson.setAge(people.getAge());
	    
	    return repository.save(existingPerson);

		
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
