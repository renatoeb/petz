package br.com.petz.project.request;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientRequest {
	
	@NotBlank(message = "Nome é obrigatorio")
	private String firstName;

	@NotBlank(message = "Sobrenome é obrigatorio")
	private String lastName;
	
	
}
