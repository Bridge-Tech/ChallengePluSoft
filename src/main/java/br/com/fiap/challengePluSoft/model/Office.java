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
public class Office {

	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	@NotBlank @Size(max=60)
	private String name;
	@NotBlank @Size(max=200)
	private String description;
	
}


