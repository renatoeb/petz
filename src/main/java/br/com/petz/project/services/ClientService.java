package br.com.petz.project.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.petz.project.entity.Client;
import br.com.petz.project.repository.ClientRepository;
import br.com.petz.project.request.ClientRequest;
import br.com.petz.project.response.ClientResponse;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;

	public static final Client converter(ClientRequest request) {
		return  Client.builder()
				 .firstName(request.getFirstName())
				 .lastName(request.getLastName())
				 .build();
				
				
	}

	public Optional<ClientResponse> create(ClientRequest client) {
		return Optional.ofNullable(new ClientResponse(repository.save(converter(client))));
	}

	public void update(Long id, Client client) {
		repository.save(client);
	}

	public Page<ClientResponse> findAll(Pageable pageable) {
		Page<Client> listClient = repository.findAll(pageable);
		return listClient.map(ClientResponse::new);
	}

	public Optional<ClientResponse> findById(Long id) {
		return Optional.ofNullable(
				 new ClientResponse(repository.getOne(id) ));

	}
	
	public void remove(Long id) {
		repository.deleteById(id);
	}


}
