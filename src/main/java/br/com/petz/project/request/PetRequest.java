package br.com.petz.project.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.petz.project.enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PetRequest {

	
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private SexEnum sex;
	
	private Double weight;
	
	private String breed;
	
	//private Long clientId;
}
