package br.com.desafiopitang.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.google.gson.Gson;

import br.com.desafiopitang.model.Car;
import br.com.desafiopitang.model.User;
import br.com.desafiopitang.validation.constraints.Email;
import br.com.desafiopitang.validation.constraints.Phone;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class UserDto {

	private Long id;
	
	@NotNull(message = "Missing fields")
	private String firstName;
	
	@NotNull(message = "Missing fields")
	private String lastName;
	
	@NotNull(message = "Missing fields")
	@Email
	private String email;
	
	@NotNull(message = "Missing fields")
	private LocalDate birthday;
	
	@NotNull(message = "Missing fields")
	private String login;
	
	@NotNull(message = "Missing fields")
	private String password;
	
	@NotNull(message = "Missing fields")
	@Phone
	private String phone;
	
	private List<CarDto> cars;
	
	public User toUsuario() {
		User entity = new User();
		
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
	
	public static UserDto fromUsuario(User entity) {
		UserDto dto = new UserDto();
		
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

	private List<Car> toListCarros(List<CarDto> cars) {
		return cars.stream()
				.map(CarDto::toCarro)
				.collect(Collectors.toList());
	}
	
	public static List<CarDto> fromListCarros(List<Car> cars) {
		return cars.stream()
				.map(CarDto::fromCar)
				.collect(Collectors.toList());
	}
	
	public static UserDto convertToJson(final String json) {
		return new Gson().fromJson(json, UserDto.class);
	}
}
