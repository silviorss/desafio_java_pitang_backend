package br.com.desafiopitang.dto;

import com.google.gson.Gson;

import br.com.desafiopitang.model.Carro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class CarroDto {

	private Long id;
	private Integer year;
	private String licensePlate;
	private String model;
	private String color;
	
	public Carro toCarro() {
		Carro entity = new Carro();
		
		entity.setId(this.id);
		entity.setYear(this.year);
		entity.setLicensePlate(this.licensePlate);
		entity.setModel(this.model);
		entity.setColor(this.color);
		
		return entity;
	}
	
	public static CarroDto fromCarro(Carro entity) {
		CarroDto dto = new CarroDto();
		
		dto.setId(entity.getId());
		dto.setYear(entity.getYear());
		dto.setLicensePlate(entity.getLicensePlate());
		dto.setModel(entity.getModel());
		dto.setColor(entity.getColor());
		
		return dto;
	}
	
	public static CarroDto convertToJson(final String json) {
		return new Gson().fromJson(json, CarroDto.class);
	}
}
