package br.com.desafiopitang.excpetion;

public class DesafioPitangException extends RuntimeException {
	
	private static final long serialVersionUID = 527167653513233589L;

	public DesafioPitangException(String message, Integer errorCode) {
		super(message);
	}
}
