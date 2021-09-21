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
public class Role {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	@NotBlank @Size(max=60, message="Nome não pode ser maior que 60 caracteres")
	private String name;
	@Size(max=100, message="Descrição não pode ser maior que 100 caracteres")
	private String description;
}
