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

import br.com.petz.project.entity.Pet;
import br.com.petz.project.request.PetRequest;
import br.com.petz.project.response.ClientResponse;
import br.com.petz.project.response.PetResponse;
import br.com.petz.project.services.PetService;

@RestController
@RequestMapping(value = "/petz/v1")
public class PetController {

	@Autowired
	private PetService petService;

	@PostMapping("/client/{clientId}/pets")
	public ResponseEntity<PetResponse> createClient(@PathVariable(value = "clientId") Long clientId,
			@Valid @RequestBody PetRequest petRequest) {
		Optional<PetResponse> response = petService.create(clientId, petRequest);
		return (response.isPresent()) ? new ResponseEntity<>(response.get(), HttpStatus.CREATED)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}")
	public void updatePet(@PathVariable Long id, @RequestBody @Valid Pet pet) {
		petService.update(id, pet);

	}

	@DeleteMapping("/{id}")
	public void deletePet(@PathVariable Long id) {
		petService.remove(id);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PetResponse> findClientById(@NotNull @PathVariable Long id) {
		Optional<PetResponse> response = petService.findById(id);
		return (response.isPresent()) ? new ResponseEntity<>(response.get(), HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
