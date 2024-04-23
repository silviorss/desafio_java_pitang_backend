package br.com.desafiopitang.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafiopitang.dao.CarsDao;
import br.com.desafiopitang.dao.UserDao;
import br.com.desafiopitang.dto.UserDto;
import br.com.desafiopitang.excpetion.EmailAlreadyExistsException;
import br.com.desafiopitang.excpetion.LoginAlreadyExistsException;
import br.com.desafiopitang.excpetion.UserNotFoundException;
import br.com.desafiopitang.model.Car;
import br.com.desafiopitang.model.User;
import br.com.desafiopitang.service.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Autowired UserDao repository;
	
	@Autowired CarsDao carRepository;
	
	@Override
	public List<UserDto> listAllUsers() {
		return repository.findAll().stream()
				.map(UserDto::fromUsuario)
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public UserDto save(UserDto dto) {
		verifyEmail(dto.getEmail());
		verifyLogin(dto.getLogin());
		User user = dto.toUsuario();
		List<Car> cars = saveCarFromUser(user.getCars());
		user.setCars(cars);
		repository.save(user);
		return UserDto.fromUsuario(user);
	}
	
	@Override
	public UserDto findById(Long id) {
		Optional<User> user = repository.findById(id);
		if(user.isPresent()) {
			return UserDto.fromUsuario(user.get());
		} else {
			throw new UserNotFoundException();
		}
	}

	private List<Car> saveCarFromUser(List<Car> cars) {
		List<Car> list = cars.stream()
				.filter(c -> !verifyLicensePlate(c.getLicensePlate()))
				.peek(c -> carRepository.save(c))
				.collect(Collectors.toList());
		return list;
	}

	private void verifyEmail(String email) {
		if(repository.existsByEmail(email)) {
			throw new EmailAlreadyExistsException();
		}
	}
	
	private void verifyLogin(String login) {
		if(repository.existsByLogin(login)) {
			throw new LoginAlreadyExistsException();
		}
	}
	
	public boolean verifyLicensePlate(String licensePlate) {
		return carRepository.existsByLicensePlate(licensePlate);
	}
}
