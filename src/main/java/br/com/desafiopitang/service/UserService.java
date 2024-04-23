package br.com.desafiopitang.service;

import java.util.List;

import br.com.desafiopitang.dto.UserDto;

public interface UserService {

	List<UserDto> listAllUsers();
	UserDto save(UserDto dto);
	UserDto findById(Long id);
	void delete(Long id);
}
