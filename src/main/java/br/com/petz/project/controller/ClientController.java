package br.com.petz.project.controller;



import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.petz.project.entity.Client;
import br.com.petz.project.request.ClientRequest;
import br.com.petz.project.response.ClientResponse;
import br.com.petz.project.services.ClientService;

@RestController
@RequestMapping(value = "/petz/v1/client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	
    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> findClientById(@NotNull @PathVariable  Long id) {
    	Optional<ClientResponse> clientResponse = clientService.findById(id);
    	return (clientResponse.isPresent()) 
    			?new ResponseEntity<>(clientResponse.get(), HttpStatus.OK) 
    			: new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PostMapping
    public ResponseEntity<ClientResponse> createClient(@Valid @RequestBody ClientRequest request) {
    	Optional<ClientResponse> clientResponse = clientService.create(request);
    	return (clientResponse.isPresent()) 
    			?new ResponseEntity<>(clientResponse.get(), HttpStatus.CREATED) 
    			: new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PutMapping("/{id}")
    public void updateClient(@PathVariable Long id, @RequestBody @Valid Client client) {
    	clientService.update(id, client);
		
    }
    
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
    	clientService.remove(id);
    }
    
   
    
	
	
}
