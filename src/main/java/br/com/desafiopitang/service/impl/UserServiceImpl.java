package br.com.desafiopitang.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafiopitang.dao.UserDao;
import br.com.desafiopitang.dto.UserDto;
import br.com.desafiopitang.service.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Autowired UserDao repository;
	
	@Override
	public List<UserDto> listAllUsers() {
		return repository.findAll().stream()
				.map(UserDto::fromUsuario)
				.collect(Collectors.toList());
	}

}
