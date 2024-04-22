package br.com.desafiopitang.excpetion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class MessageErrorField {

	private String fieldName;
	private String message;
	private StatusCodeException errorCode;
}
