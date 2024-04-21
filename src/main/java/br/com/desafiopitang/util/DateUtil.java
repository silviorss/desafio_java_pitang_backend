package br.com.desafiopitang.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class DateUtil {

	public static LocalDate convertStringToLocalDate(String dataString, String pattern) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
			return LocalDate.parse(dataString, formatter);
		} catch (RuntimeException e) {
			return null;
		}
	}
	
	public static String convertLocaDateToString(LocalDate date, String pattern) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
			return date.format(formatter);
		} catch (RuntimeException e) {
			return null;
		}
	}
}
