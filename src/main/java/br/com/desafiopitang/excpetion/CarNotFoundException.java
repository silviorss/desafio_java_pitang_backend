package br.com.desafiopitang.excpetion;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CarNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String status;
	private Integer code;

	
	public CarNotFoundException(String status, Integer code) {
		super("Car not found");
		this.status = status;
		this.code = code;
	}
	
	public CarNotFoundException(String message, String status, Integer code) {
		super(message);
		this.status = status;
		this.code = code;
	}
}
