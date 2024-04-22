package br.com.desafiopitang.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "car")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Car implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "car_id_seq", sequenceName = "car_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_id_seq")
	@Column(name = "id_car")
	private Long id;
	
	@Column(name = "year")
	private Integer year;
	
	@Column(name = "licensePlate")
	private String licensePlate;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "color")
	private String color;
}
