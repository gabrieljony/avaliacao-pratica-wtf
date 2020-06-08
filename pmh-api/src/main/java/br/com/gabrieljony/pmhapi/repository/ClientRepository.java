package br.com.gabrieljony.pmhapi.repository;

import br.com.gabrieljony.pmhapi.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
