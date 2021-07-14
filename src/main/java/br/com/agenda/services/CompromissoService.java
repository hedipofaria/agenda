package br.com.agenda.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.agenda.entities.Compromisso;
import br.com.agenda.entities.Juiz;
import br.com.agenda.repositories.CompromissoRepository;
import br.com.agenda.repositories.JuizRepository;

@Component
public class CompromissoService {

	@Autowired
	private CompromissoRepository repository;

	@Autowired
	private JuizRepository juizRepository;

	public List<Compromisso> findAll(){
		return repository.findAll();
	}
	
	public Compromisso findById(Long id) {
		Optional<Compromisso> obj = repository.findById(id);
		return obj.get();
	}

	public List<Compromisso> findBydiaAndJuiz(LocalDate dia, Long id) {
		Juiz juiz = juizRepository.findById(id).get();
		List<Compromisso> obj = repository.findBydiaAndJuiz(dia,juiz);
		return obj;
	}

	public Compromisso insert(Compromisso obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Compromisso update(Long id, Compromisso obj) {
		Compromisso entity = findById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Compromisso entity, Compromisso obj) {
		entity.setDia(obj.getDia());
		entity.setHoraQueComeca(obj.getHoraQueComeca());
		entity.setHoraQueTermina(obj.getHoraQueTermina());
		entity.setTexto(obj.getTexto());
	}
}
