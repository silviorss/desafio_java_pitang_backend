package br.com.desafiopitang.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CryptPasswordUtil {

	public static String bCryptPasswordEncoder(String dados){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return (encoder.encode(dados));
	}
	
	public static boolean comparteByCryptPasswordEncoder(String password, String senhaCrypt) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.matches(password, senhaCrypt);
	}
}
