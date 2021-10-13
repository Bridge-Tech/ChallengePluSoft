package br.com.fiap.challengePluSoft.model;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
@Entity
public class Employee implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	@NotBlank(message = "Nome não pode se nulo/ vazio")
	private String name;
	@NotBlank
	private String birthdate;
	@Size( max=1 ,message="Esse valor so pode conter M - Masculino F - Feminino N - Prefiro Não identificar ")
	private String sex;
	@NotBlank @Size(max=100, message="User não pode ter mais de 100 caracteres")
	private String user;
	@NotBlank @Size(max=60, min = 1,message="Senha não pode conter mais que 10 caracteres e não pode conter somente 1 caractere")
	private String password;
	@ManyToMany(fetch= FetchType.EAGER)
	private Collection<Role> roles;
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		/*
		 * Conseguir Pegar da tabela Permission e
		 *  colocar as permissoes nas pessoas por aqui! */
		return this.roles;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.user;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		
		/*
		 * Conseguir Pegar da tabela Person e
		 *  desabilitar as pessoas por aqui! */
		return true;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}
}
