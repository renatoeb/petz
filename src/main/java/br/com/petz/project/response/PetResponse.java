package br.com.petz.project.response;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.petz.project.entity.Pet;
import br.com.petz.project.enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PetResponse {
	
	
	public PetResponse(Pet request) {
		
		this.name = request.getName();
		this.sex = request.getSex();
		this.weight = request.getWeight();
		this.breed = request.getBreed();
	}
	
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private SexEnum sex;
	
	private Double weight;
	

	private String breed;

}
