package br.com.desafiopitang.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "usuario")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "usuario_id_seq", sequenceName = "usuario_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_id_seq")
	@Column(name = "id_usuario")
	private Long id;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "birthday")
	private LocalDate birthday;
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "phone")
	private String phone;
	
	@OneToMany
	@JoinTable(name = "usuario_carros",
	joinColumns = {@JoinColumn(name = "id_usuario")},
	inverseJoinColumns = {@JoinColumn(name = "id_carro")})
	private List<Carro> cars;
}
