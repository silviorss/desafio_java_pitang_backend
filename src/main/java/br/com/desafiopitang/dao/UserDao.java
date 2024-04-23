package br.com.desafiopitang.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafiopitang.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Long>{

	boolean existsByEmail(String email);
	Optional<User> findByEmail(String email);
	boolean existsByLogin(String login);
	Optional<User> findByLogin(String login);
}
