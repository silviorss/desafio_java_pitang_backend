package br.com.desafiopitang.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafiopitang.dao.CarsDao;
import br.com.desafiopitang.dto.CarDto;
import br.com.desafiopitang.excpetion.CarNotDeleteException;
import br.com.desafiopitang.excpetion.CarNotFoundException;
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
		verifyLicensePlate(dto.getLicensePlate());
		Car carro = dto.toCarro();
		repository.save(carro);
		return CarDto.fromCar(carro);
	}
	
	@Override
	public CarDto findById(Long id) {
		Optional<Car> car = repository.findById(id);
		if(car.isPresent()) {
			return CarDto.fromCar(car.get());
		} else {
			throw new CarNotFoundException();
		}
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		Optional<Car> car = repository.findById(id);
		if(car.isPresent()) {
			repository.delete(car.get());
		} else {
			throw new CarNotDeleteException();
		}
	}
	
	@Override
	@Transactional
	public CarDto update(Long id, CarDto dto) {
		verifyLicensePlateUpdate(id, dto);
		Car carro = dto.toCarro();
		Optional<Car> carUpdate = repository.findById(id);
		Car update = mapper(carro, carUpdate.get());
		repository.save(update);
		return CarDto.fromCar(carro);
	}
	
	private void verifyLicensePlate(String licensePlate) {
		if(repository.existsByLicensePlate(licensePlate)) {
			throw new LicensePlateAlreadyExistsException();
		}
	}
	
	private void verifyLicensePlateUpdate(Long id, CarDto dto) {
		Optional<Car> car = repository.findByLicensePlate(dto.getLicensePlate());
		if(car.isPresent()) {
			if(!car.get().getId().equals(id)) {
				throw new LicensePlateAlreadyExistsException();
			}
		}
	}
	
	private Car mapper(Car carro, Car carUpdate) {
		carUpdate.setYear(carro.getYear());
		carUpdate.setLicensePlate(carro.getLicensePlate());
		carUpdate.setModel(carro.getModel());
		carUpdate.setColor(carro.getColor());
		return carUpdate;
	}
}
