package br.com.gabrieljony.pmhapi.repository;

import br.com.gabrieljony.pmhapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
