package br.com.desafiopitang.excpetion;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LicensePlateAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String status;
	private Integer code;

	public LicensePlateAlreadyExistsException(String status, Integer code) {
		super("License plate already exists");
		this.status = status;
		this.code = code;
	}
	
	public LicensePlateAlreadyExistsException(String message, String status, Integer code) {
		super(message);
		this.status = status;
		this.code = code;
	}
}
