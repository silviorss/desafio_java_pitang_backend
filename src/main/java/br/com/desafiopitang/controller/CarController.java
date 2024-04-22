package br.com.desafiopitang.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafiopitang.dto.CarDto;
import br.com.desafiopitang.service.CarService;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RestController
@RequestMapping("/api/cars")
public class CarController {

	@Autowired CarService service;
	
	@GetMapping
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<List<CarDto>> buscar() {
		return ResponseEntity.ok(service.listAllCars());
	}
	
	@PostMapping
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<CarDto> salvar(
			@RequestBody @Valid CarDto dto) {
		return ResponseEntity.ok(service.save(dto));
	}
	
	@GetMapping("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<CarDto> findById(
			@PathVariable("id") Long id) {
		return ResponseEntity.ok(service.findById(id));
	}
	
}
