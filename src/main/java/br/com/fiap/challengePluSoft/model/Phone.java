package br.com.fiap.challengePluSoft.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Phone {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(max = 30 ,message = "Numero não pode ser maior que 30")
	private String number;
	@Size(max = 30, message = "Descrição não pode ser maior que 30")
	private String description;
}
