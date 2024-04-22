package br.com.desafiopitang.validation.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LicensePlateValidation implements ConstraintValidator<LicensePlate, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		String licensePlate = value == null ? "" :  value;
		return licensePlate.matches("[a-zA-Z]{3}-[0-9][A-Za-z0-9][0-9]{2}");
	}

}
