package br.com.agenda.resources;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.agenda.entities.Compromisso;
import br.com.agenda.services.CompromissoService;

@RestController
@RequestMapping(value = "/compromissos")
public class CompromissoResource {

	@Autowired
	private CompromissoService service;
	
	@GetMapping
	public ResponseEntity<List<Compromisso>> findAll(){
		List<Compromisso> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Compromisso> findById(@PathVariable Long id){
		Compromisso obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping(value = "/{id}/{dia}")
	public ResponseEntity<List<Compromisso>> findBydiaAndJuiz(@PathVariable Long id, @PathVariable String dia){
		List<Compromisso> listObjs = service.findBydiaAndJuiz(LocalDate.parse(dia),id);
		return ResponseEntity.ok().body(listObjs);
	}
	
	@PostMapping
	public ResponseEntity<Compromisso> insert(@RequestBody Compromisso obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(obj.getId())
					.toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Compromisso> update(@PathVariable Long id, @RequestBody Compromisso obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
