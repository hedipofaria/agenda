package br.com.agenda.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Compromisso implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String texto;
	
	private LocalDate dia;
	
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private LocalTime horaQueComeca;
	
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private LocalTime horaQueTermina;
	
	@ManyToOne
	@JoinColumn(name = "juiz_id")
	private Juiz juiz;
	
	public Compromisso() {
	}

	public Compromisso(Long id, String texto, LocalDate dia, LocalTime horaQueComeca, LocalTime horaQueTermina, Juiz juiz) {
		super();
		this.id = id;
		this.texto = texto;
		this.dia = dia;
		this.horaQueComeca = horaQueComeca;
		this.horaQueTermina = horaQueTermina;
		this.juiz = juiz;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalTime getHoraQueComeca() {
		return horaQueComeca;
	}

	public void setHoraQueComeca(LocalTime horaQueComeca) {
		this.horaQueComeca = horaQueComeca;
	}

	public LocalTime getHoraQueTermina() {
		return horaQueTermina;
	}

	public void setHoraQueTermina(LocalTime horaQueTermina) {
		this.horaQueTermina = horaQueTermina;
	}

	public LocalDate getDia() {
		return dia;
	}

	public void setDia(LocalDate dia) {
		this.dia = dia;
	}

	public Juiz getJuiz() {
		return juiz;
	}

	public void setJuiz(Juiz juiz) {
		this.juiz = juiz;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compromisso other = (Compromisso) obj;
		return Objects.equals(id, other.id);
	}
	
}
