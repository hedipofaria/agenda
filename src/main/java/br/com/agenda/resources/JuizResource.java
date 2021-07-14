package br.com.agenda.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agenda.entities.Juiz;
import br.com.agenda.services.JuizService;

@RestController
@RequestMapping(value = "/juizes")
public class JuizResource {

	@Autowired
	private JuizService service;
	
	@GetMapping
	public ResponseEntity<List<Juiz>> findAll(){
		List<Juiz> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Juiz> findById(@PathVariable Long id){
		Juiz j = service.findById(id);
		return ResponseEntity.ok().body(j);
	}
	
}
