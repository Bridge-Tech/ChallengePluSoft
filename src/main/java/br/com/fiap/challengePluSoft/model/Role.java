package br.com.fiap.challengePluSoft.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
@Entity
public class Role implements GrantedAuthority{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	@NotBlank @Size(max=60, message="Nome não pode ser maior que 60 caracteres")
	private String name;
	@Size(max=300, message="Descrição não pode ser maior que 300 caracteres")
	private String description;
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.name;
	}
}
