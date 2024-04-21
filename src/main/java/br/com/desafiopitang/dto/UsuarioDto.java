package br.com.desafiopitang.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.google.gson.Gson;

import br.com.desafiopitang.model.Carro;
import br.com.desafiopitang.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class UsuarioDto {

	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private LocalDate birthday;
	private String login;
	private String password;
	private String phone;
	private List<CarroDto> cars;
	
	public Usuario toUsuario() {
		Usuario entity = new Usuario();
		
		entity.setId(this.id);
		entity.setFirstName(this.firstName);
		entity.setLastName(this.lastName);
		entity.setEmail(this.email);
		entity.setBirthday(birthday);
		entity.setLogin(this.login);
		entity.setPassword(this.password);
		entity.setPhone(this.phone);
		entity.setCars((Objects.nonNull(this.cars)) ? toListCarros(this.cars) : null);
		
		return entity;
	}
	
	public static UsuarioDto fromUsuario(Usuario entity) {
		UsuarioDto dto = new UsuarioDto();
		
		dto.setId(entity.getId());
		dto.setFirstName(entity.getFirstName());
		dto.setLastName(entity.getLastName());
		dto.setEmail(entity.getEmail());
		dto.setBirthday(entity.getBirthday());
		dto.setLogin(entity.getLogin());
		dto.setPassword(entity.getPassword());
		dto.setPhone(entity.getPhone());
		dto.setCars((Objects.nonNull(entity.getCars())) ? fromListCarros(entity.getCars()) : null);
		return dto;
	}

	private List<Carro> toListCarros(List<CarroDto> cars) {
		return cars.stream()
				.map(CarroDto::toCarro)
				.collect(Collectors.toList());
	}
	
	public static List<CarroDto> fromListCarros(List<Carro> cars) {
		return cars.stream()
				.map(CarroDto::fromCarro)
				.collect(Collectors.toList());
	}
	
	public static UsuarioDto convertToJson(final String json) {
		return new Gson().fromJson(json, UsuarioDto.class);
	}
}
