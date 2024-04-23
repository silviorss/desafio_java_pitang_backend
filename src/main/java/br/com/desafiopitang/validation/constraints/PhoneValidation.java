package br.com.desafiopitang.validation.constraints;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidation implements ConstraintValidator<Phone, String> {
	private static final String PHONE_NUMBER_PATTERN = "^\\(\\d{2}\\)\\s\\d{1}\\s\\d{4}-\\d{4}$";
    private Pattern pattern;
    
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		String phone = value == null ? "" : value;
		pattern = Pattern.compile(PHONE_NUMBER_PATTERN);
		Matcher matcher = pattern.matcher(phone);
		return matcher.matches();
	}

}
