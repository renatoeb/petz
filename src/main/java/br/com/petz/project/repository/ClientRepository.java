package br.com.petz.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.petz.project.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
