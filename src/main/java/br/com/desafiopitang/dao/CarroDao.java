package br.com.desafiopitang.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafiopitang.model.Carro;

@Repository
public interface CarroDao extends JpaRepository<Carro, Long>{

}
