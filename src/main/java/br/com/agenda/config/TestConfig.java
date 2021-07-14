package br.com.agenda.config;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.agenda.entities.Compromisso;
import br.com.agenda.entities.Juiz;
import br.com.agenda.repositories.CompromissoRepository;
import br.com.agenda.repositories.JuizRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private JuizRepository juizRepository;

	@Autowired
	private CompromissoRepository compromissoRepository;

	@Override
	public void run(String... args) throws Exception {
		Juiz juizValentin = new Juiz(null, "Valentin");
		Juiz juizJoao = new Juiz(null, "Joao");

		Compromisso c1 = new Compromisso(null, "91ª Sessão Extraordinária do Tribunal Pleno"									, LocalDate.parse("2021-07-14"),LocalTime.parse("00:00:00"),LocalTime.parse("23:50:00"), juizValentin);
		Compromisso c2 = new Compromisso(null, "Solenidade de Posse do Senhor Procurador de Justiça Dr. Bento Faria"			, LocalDate.parse("2021-07-15"),LocalTime.parse("10:15:00"),LocalTime.parse("14:45:00"), juizValentin);
		Compromisso c3 = new Compromisso(null, "PLANTÃO JUDICIAL PRESIDENTE"													, LocalDate.parse("2021-07-16"),LocalTime.parse("08:00:00"),LocalTime.parse("12:00:00"), juizValentin);
		Compromisso c4 = new Compromisso(null, "PLANTÃO JUDICIAL PRESIDENTE"													, LocalDate.parse("2021-07-16"),LocalTime.parse("14:00:00"),LocalTime.parse("18:00:00"), juizValentin);
		Compromisso c5 = new Compromisso(null, "Cerimônia de Lançamento do projeto piloto de integração do e-Carta ao PJe."		, LocalDate.parse("2021-07-19"),LocalTime.parse("09:15:00"),LocalTime.parse("15:15:00"), juizValentin);
		Compromisso c6 = new Compromisso(null, "97ª SESSÃO ORDINÁRIA POR VIDEOCONFERENCIA DA 9ª TURMA CÍVEL"					, LocalDate.parse("2021-07-20"),LocalTime.parse("07:00:00"),LocalTime.parse("11:30:00"), juizValentin);
		Compromisso c7 = new Compromisso(null, "Sessão Pública de Escolha de Serventias para as Funções Notariais e de Registro", LocalDate.parse("2021-07-21"),LocalTime.parse("15:00:00"),LocalTime.parse("16:00:00"), juizValentin);
		Compromisso c8 = new Compromisso(null, "99ª Sessão Extraordinária do Tribunal Pleno"									, LocalDate.parse("2021-07-22"),LocalTime.parse("14:15:00"),LocalTime.parse("14:15:00"), juizValentin);
		Compromisso c9 = new Compromisso(null, "PLANTÃO JUDICIAL PRESIDENTE"													, LocalDate.parse("2021-07-23"),LocalTime.parse("16:00:00"),LocalTime.parse("16:30:00"), juizValentin);
		Compromisso c10 = new Compromisso(null, "PLANTÃO JUDICIAL PRESIDENTE"													, LocalDate.parse("2021-07-16"),LocalTime.parse("08:00:00"),LocalTime.parse("16:00:00"), juizJoao);

		juizValentin.getCompromissos().addAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9));
		juizJoao.getCompromissos().addAll(Arrays.asList(c10));
		
		juizRepository.saveAll(Arrays.asList(juizValentin,juizJoao));
		compromissoRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10));
	}
	
	
}
