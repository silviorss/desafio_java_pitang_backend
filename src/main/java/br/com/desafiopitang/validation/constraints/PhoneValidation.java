package br.com.desafiopitang.validation.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidation implements ConstraintValidator<Phone, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		String phone = value == null ? "" : value;
		return phone.matches("([0-9]){2} [0-9]{1} [0-9]{4}-[0-9]");
	}

}
