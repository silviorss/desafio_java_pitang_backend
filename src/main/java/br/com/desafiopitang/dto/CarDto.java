package br.com.desafiopitang.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.google.gson.Gson;

import br.com.desafiopitang.model.Car;
import br.com.desafiopitang.validation.constraints.LicensePlate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class CarDto {

	private Long id;
	
	@NotNull(message = "Missing fields")
	private Integer year;
	
	@NotBlank(message = "Missing fields")
	@LicensePlate
	private String licensePlate;
	
	@NotBlank(message = "Missing fields")
	private String model;
	
	@NotBlank(message = "Missing fields")
	private String color;
	
	public Car toCarro() {
		Car entity = new Car();
		
		entity.setId(this.id);
		entity.setYear(this.year);
		entity.setLicensePlate(this.licensePlate);
		entity.setModel(this.model);
		entity.setColor(this.color);
		
		return entity;
	}
	
	public static CarDto fromCar(Car entity) {
		CarDto dto = new CarDto();
		
		dto.setId(entity.getId());
		dto.setYear(entity.getYear());
		dto.setLicensePlate(entity.getLicensePlate());
		dto.setModel(entity.getModel());
		dto.setColor(entity.getColor());
		
		return dto;
	}
	
	public static CarDto convertToJson(final String json) {
		return new Gson().fromJson(json, CarDto.class);
	}
}
