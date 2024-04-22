package br.com.desafiopitang.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafiopitang.model.Car;

@Repository
public interface CarsDao extends JpaRepository<Car, Long>{

	boolean existsByLicensePlate(String licensePlate);
}
