package br.com.fiap.challengePluSoft.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Address {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank @Size(max = 60, message="O Cidade não pode ser maior que 10")
	private String city;
	@NotBlank @Size(max = 60, message="O Bairro não pode ser maior que 10")
	private String district;
	@NotBlank @Size(max = 30, message="O CEP não pode ser maior que 10")
	private String cep;
	@NotBlank @Size(max = 30, message="O estado não pode ser maior que 30")
	private String state;
	
	
	
	
	
	
	
}
