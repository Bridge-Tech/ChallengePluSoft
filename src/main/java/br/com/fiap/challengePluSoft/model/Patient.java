package br.com.fiap.challengePluSoft.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Patient {
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Nome não pode se nulo/ vazio")
	private String name;
	private String birthdate;
	@Size( max=1 ,message="Esse valor so pode conter M - Masculino F - Feminino N - Prefiro Não identificar ")
	private String sex;
	
	@ManyToOne
	private Employee employee;
	@ManyToOne
	private Phone phone;
}
