package br.com.desafiopitang.excpetion;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String status;
	private Integer code;
	
	public LoginAlreadyExistsException() {
		super("Login already exists");
		this.status = HttpStatus.CONFLICT.name();
		this.code = HttpStatus.CONFLICT.value();
	}
	
	public LoginAlreadyExistsException(String message, String status, Integer code) {
		super(message);
		this.status = status;
		this.code = code;
	}
}
