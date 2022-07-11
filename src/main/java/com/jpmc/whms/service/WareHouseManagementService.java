/**
 * 
 */
package com.jpmc.whms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.jpmc.whms.dto.CartoWareHouseRequestDto;
import com.jpmc.whms.dto.CartoWareHouseResponseDto;
import com.jpmc.whms.dto.PurChaseCarRequestDto;
import com.jpmc.whms.entity.Car;
import com.jpmc.whms.entity.mapper.WareHouseMapper;
import com.jpmc.whms.exception.CarNotFoundException;
import com.jpmc.whms.service.repository.WareHouseRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author madhukargunda
 *
 */
@Service
@Slf4j
public class WareHouseManagementService {

	@Autowired
	WareHouseRepository wareHouseRepository;

	@Autowired
	WareHouseMapper wareHouseMapper;

	/**
	 * Adds the Car to wareHouse
	 * 
	 * @param productDto
	 */

	@Transactional
	public Car addCarToWareHouse(CartoWareHouseRequestDto addCarToWareHouseRequest) {
		Car car = wareHouseMapper.mapWareHouseToEntity(addCarToWareHouseRequest);
		return wareHouseRepository.save(car);
	}

	/**
	 * Get AvailableCarsFrom Where house
	 * 
	 * @return
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public List<CartoWareHouseResponseDto> getAvailableCarsFromWareHouse() {
		List<Car> avaialbleCars = wareHouseRepository.findBySoldFalse();
		return avaialbleCars
				.stream()
				.map(s -> wareHouseMapper.mapEntityToDto(s))
				.collect(Collectors.toList());
	}

	
	@Transactional
	public Car purchaseCar(PurChaseCarRequestDto purchaseRequestDto) {
		log.info("The PurchaseCarRequestDto {}",purchaseRequestDto);
		Car car = wareHouseRepository.findById(purchaseRequestDto.getId())
			.filter(s -> !s.isSold())
			.orElseThrow(() -> new CarNotFoundException("Car Not Available"));
		car.setSold(Boolean.TRUE);	
		car.setFinalPrice(purchaseRequestDto.getFinalPrice());
		log.info("The final price is {}",purchaseRequestDto.getFinalPrice());
		return wareHouseRepository.saveAndFlush(car);
	}
	
	
	public void deleteCarFromWareHouse(Long id) {
		wareHouseRepository.deleteById(id);
	}

}
