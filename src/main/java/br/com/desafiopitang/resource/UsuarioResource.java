package br.com.desafiopitang.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafiopitang.service.UsuarioService;

@RestController
@RequestMapping("/api/users")
public class UsuarioResource {

	@Autowired UsuarioService service;
}
