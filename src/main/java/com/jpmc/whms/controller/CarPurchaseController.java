package com.jpmc.whms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpmc.whms.dto.PurChaseCarRequestDto;
import com.jpmc.whms.entity.Car;
import com.jpmc.whms.service.WareHouseManagementService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/whms")
public class CarPurchaseController {

	@Autowired
	WareHouseManagementService wareHouseService;

	@PostMapping("/cars/{id}/buy")
	public Car buyCarFromWareHouse(@PathVariable String id, @RequestBody PurChaseCarRequestDto purchaseCarRequestDto) {
		log.info("purchasing the car {} ", purchaseCarRequestDto);
		return wareHouseService.purchaseCar(purchaseCarRequestDto);
	}

}
