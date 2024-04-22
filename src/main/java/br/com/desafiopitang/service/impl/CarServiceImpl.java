package br.com.desafiopitang.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.desafiopitang.dao.CarsDao;
import br.com.desafiopitang.dto.CarDto;
import br.com.desafiopitang.excpetion.LicensePlateAlreadyExistsException;
import br.com.desafiopitang.model.Car;
import br.com.desafiopitang.service.CarService;

@Service(value = "carService")
public class CarServiceImpl implements CarService {

	@Autowired CarsDao repository;

	@Override
	public List<CarDto> listAllCars() {
		return repository.findAll().stream()
				.map(CarDto::fromCar)
				.collect(Collectors.toList());
	}
	
	@Override
	@Transactional
	public CarDto save(CarDto dto) {
		verifyLicensePlate(dto);
		Car carro = dto.toCarro();
		repository.save(carro);
		return CarDto.fromCar(carro);
	}
	
	private void verifyLicensePlate(CarDto dto) {
		if(repository.existsByLicensePlate(dto.getLicensePlate())) {
			throw new LicensePlateAlreadyExistsException(HttpStatus.CONFLICT.name(), HttpStatus.CONFLICT.value());
		}
	}
}
