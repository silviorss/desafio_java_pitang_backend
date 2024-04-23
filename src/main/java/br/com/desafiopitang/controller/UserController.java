package br.com.desafiopitang.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafiopitang.dto.UserDto;
import br.com.desafiopitang.service.UserService;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired UserService service;

	@GetMapping
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<List<UserDto>> getAll() {
		return ResponseEntity.ok(service.listAllUsers());
	}

	@PostMapping
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<UserDto> save(
			@RequestBody @Valid UserDto dto) {
		return ResponseEntity.ok(service.save(dto));
	}

	@GetMapping("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<UserDto> findById(
			@PathVariable("id") Long id) {
		return ResponseEntity.ok(service.findById(id));
	}
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{id}")
	public ResponseEntity deleteById(
			@PathVariable("id") Long id) {
		service.delete(id);
		return ResponseEntity.ok().build(); 
	}
}
