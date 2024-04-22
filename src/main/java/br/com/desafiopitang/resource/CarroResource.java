package br.com.desafiopitang.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafiopitang.dto.CarroDto;
import br.com.desafiopitang.service.CarroService;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RestController
@RequestMapping("/api/cars")
public class CarroResource {

	@Autowired CarroService service;
	
	@GetMapping
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<List<CarroDto>> buscar() {
		return ResponseEntity.ok(service.listar());
	}
}
