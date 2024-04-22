package br.com.desafiopitang.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafiopitang.dao.CarroDao;
import br.com.desafiopitang.dto.CarroDto;
import br.com.desafiopitang.service.CarroService;

@Service(value = "carroService")
public class CarroServiceImpl implements CarroService {

	@Autowired CarroDao repository;

	@Override
	public List<CarroDto> listar() {
		return repository.findAll().stream()
				.map(CarroDto::fromCarro)
				.collect(Collectors.toList());
	}
	
	
}
