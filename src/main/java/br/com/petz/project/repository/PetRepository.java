package br.com.petz.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.petz.project.entity.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
