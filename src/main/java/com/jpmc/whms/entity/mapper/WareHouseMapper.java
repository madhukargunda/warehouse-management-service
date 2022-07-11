/**
 * 
 */
package com.jpmc.whms.entity.mapper;

import org.springframework.stereotype.Component;

import com.jpmc.whms.dto.CartoWareHouseRequestDto;
import com.jpmc.whms.dto.CartoWareHouseResponseDto;
import com.jpmc.whms.entity.Car;

import lombok.extern.slf4j.Slf4j;

/**
 * @author madhukargunda
 *
 */ 

@Component
@Slf4j
public class WareHouseMapper {

	/**
	 * Utility method used to converting the RequestDTO to Entity
	 * 
	 * 
	 * @param addCarToWareHouseRequestDto
	 * @return
	 */
	public Car mapWareHouseToEntity(CartoWareHouseRequestDto addCarToWareHouseRequestDto) {
		log.info("Conveting the addCarToWareHouseRequest to RequestDTO");
		final Car car = new Car();
		car.setDescription(addCarToWareHouseRequestDto.getDescription());
		car.setMake(addCarToWareHouseRequestDto.getMake());
		car.setModel(addCarToWareHouseRequestDto.getModel());
		car.setOriginalPrice(addCarToWareHouseRequestDto.getPrice());
		car.setName(addCarToWareHouseRequestDto.getName());
		car.setSold(Boolean.FALSE);
		return car;
	}
	
	
	public CartoWareHouseResponseDto mapEntityToDto(Car car) {
		log.info("Conveting the addCarToWareHouseRequest to RequestDTO");
		CartoWareHouseResponseDto responsedto = new CartoWareHouseResponseDto();		
		responsedto.setDescription(car.getDescription());
		responsedto.setId(car.getId());
		responsedto.setMake(car.getMake());
		responsedto.setModel(car.getModel());
		responsedto.setPrice(car.getOriginalPrice());	
		responsedto.setName(car.getName());
		return responsedto;
	}
}
