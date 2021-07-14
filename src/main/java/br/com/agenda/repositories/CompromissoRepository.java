package br.com.agenda.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agenda.entities.Compromisso;
import br.com.agenda.entities.Juiz;

public interface CompromissoRepository extends JpaRepository<Compromisso, Long>{

	List<Compromisso> findBydiaAndJuiz(LocalDate dia, Juiz juiz);
	
}
