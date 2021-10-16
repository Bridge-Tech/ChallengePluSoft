package br.com.fiap.challengePluSoft.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Note {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(max=1000, message="Descrição não pode ser maior que 1000 caracteres")
	private String description;
	@ManyToOne
	private Employee employee;
	private String date;
}
