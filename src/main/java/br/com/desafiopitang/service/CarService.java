package br.com.desafiopitang.service;

import java.util.List;

import br.com.desafiopitang.dto.CarDto;

public interface CarService {

	List<CarDto> listAllCars();
	CarDto save(CarDto dto);
	CarDto findById(Long id);
}
