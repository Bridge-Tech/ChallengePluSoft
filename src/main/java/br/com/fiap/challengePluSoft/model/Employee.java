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
public class Employee {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	@NotBlank @Size(max=100, message="User não pode ter mais de 100 caracteres")
	private String user;
	@NotBlank @Size(max=10, min = 1,message="Senha não pode conter mais que 10 caracteres e não pode conter somente 1 caractere")
	private String password;
}
