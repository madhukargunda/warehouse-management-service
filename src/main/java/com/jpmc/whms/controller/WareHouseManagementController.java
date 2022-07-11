package com.jpmc.whms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpmc.whms.dto.CartoWareHouseRequestDto;
import com.jpmc.whms.dto.CartoWareHouseResponseDto;
import com.jpmc.whms.entity.Car;
import com.jpmc.whms.service.WareHouseManagementService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/whms")
public class WareHouseManagementController {

	@Autowired
	WareHouseManagementService wareHouseService;

	@PostMapping("/cars")
	public ResponseEntity<Car> addProduct(@RequestBody @Valid CartoWareHouseRequestDto addCartoWareHouseRequest) {
		log.info("Adding new Car to warehouse {}", addCartoWareHouseRequest);
		return new ResponseEntity<>(wareHouseService.addCarToWareHouse(addCartoWareHouseRequest), HttpStatus.CREATED);
	}

	@GetMapping("/cars")
	public List<CartoWareHouseResponseDto> getAllCarsFromWareHouse() {
		return wareHouseService.getAvailableCarsFromWareHouse();
	}

	@DeleteMapping("/cars/{id}")
	public Object deleteCarFromWareHouse(@PathVariable Long id) {
		wareHouseService.deleteCarFromWareHouse(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
