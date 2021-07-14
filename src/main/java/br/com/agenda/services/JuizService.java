package br.com.agenda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.agenda.entities.Juiz;
import br.com.agenda.repositories.JuizRepository;

@Component
public class JuizService {

	@Autowired
	private JuizRepository repository;
	
	public List<Juiz> findAll(){
		return repository.findAll();
	}
	
	public Juiz findById(Long id) {
		Optional<Juiz> obj = repository.findById(id);
		return obj.get();
	}
	
}
