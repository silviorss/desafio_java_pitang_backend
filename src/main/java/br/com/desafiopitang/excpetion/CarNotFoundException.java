package br.com.desafiopitang.excpetion;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CarNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String status;
	private Integer code;

	
	public CarNotFoundException() {
		super("Car not found");
		this.status = HttpStatus.NOT_FOUND.name();
		this.code = HttpStatus.NOT_FOUND.value();
	}
	
	public CarNotFoundException(String message, String status, Integer code) {
		super(message);
		this.status = status;
		this.code = code;
	}
}
