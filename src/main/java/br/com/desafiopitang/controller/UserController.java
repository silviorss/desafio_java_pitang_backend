package br.com.desafiopitang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafiopitang.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired UserService service;
}
