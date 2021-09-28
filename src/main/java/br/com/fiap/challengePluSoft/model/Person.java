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
public class Person {

	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Nome não pode se nulo/ vazio")
	private String name;

	/* VERIFICAR COMO UTILIZAR CHAVE ESTRANGEIRA
	 * private Long idAddress;
	private Long idPhone;
	@Size(max=10, min=8, message="O telefone deve ter entre 08 a 10 caracteres ex: 00000-0000")
	private String phone;
	@Size(max=30, message="A descrição do telefone deve ter no máximo 30 caracteres")
	private String phoneDescription;*/

	private String birthdate;
	@Size( max=1 ,message="Esse valor so pode conter M - Masculino F - Feminino N - Prefiro Não identificar ")
	private String sex;
}
