package com.jpmc.whms.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpmc.whms.entity.Car;

public interface WareHouseRepository extends JpaRepository<Car, Long> {
	
	public List<Car> findBySoldFalse();

}
