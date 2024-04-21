package br.com.desafiopitang.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafiopitang.model.Usuario;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Long>{

}
