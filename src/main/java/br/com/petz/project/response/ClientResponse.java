package br.com.petz.project.response;

import java.util.Optional;

import br.com.petz.project.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientResponse {
	public ClientResponse(Client client) {
		
			this.id = client.getIdClient();
			this.firstName = client.getFirstName();
			this.lastName = client.getLastName();
		
	}
	

	private Long id;

	private String firstName;
	
	private String lastName;
	
	
	

}
