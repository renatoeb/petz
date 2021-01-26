package br.com.petz.project.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.petz.project.entity.Client;
import br.com.petz.project.entity.Pet;
import br.com.petz.project.repository.PetRepository;
import br.com.petz.project.request.PetRequest;
import br.com.petz.project.response.PetResponse;

@Service
public class PetService {

	@Autowired
	private PetRepository petRepository;
	
	public static final Pet converter(Long clientId,PetRequest request) {
		return  Pet.builder()
				   .name(request.getName())
				   .breed(request.getBreed())
				   .sex(request.getSex())
				   .weight(request.getWeight())
				   .client(Client.builder().idClient(clientId).build())
				   .build();
	}
	
	
	
	public void update(Long id, Pet pet) {
		petRepository.save(pet);
	}

	public Page<PetResponse> findAll(Pageable pageable) {
		Page<Pet> listClient = petRepository.findAll(pageable);
		return listClient.map(PetResponse::new);
	}

	public Optional<PetResponse> findById(Long id) {
		return Optional.ofNullable(
				 new PetResponse(petRepository.getOne(id) ));

	}
	
	public void remove(Long id) {
		petRepository.deleteById(id);
	}
	
	
	public Optional<PetResponse> create(Long clientId,PetRequest petRequest) {
		return Optional.ofNullable(new PetResponse(petRepository.save(converter(clientId,petRequest))));
	}

}
