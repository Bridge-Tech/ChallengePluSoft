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
public class Monitoring {
	
	
	  @Id private Long id;
	  //@ManyToOne 
	  //private Patient patient; 
//	  
//	  private Boolean risk; 
//	  private String label;
//	  private Float temperature;
//	  private String msgTemperature;
//	  private Float oxygen;
//	  private String msgOxygen;
//	  private Float heartBeats;
//	  private String msgHeartBeats;
//	  private Integer breatherSpeed;
//	 
	
}
