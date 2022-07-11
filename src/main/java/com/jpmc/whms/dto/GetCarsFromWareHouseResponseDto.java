package com.jpmc.whms.dto;

import java.util.List;

import lombok.Data;

@Data
public class GetCarsFromWareHouseResponseDto {

	List<CartoWareHouseResponseDto> availableCarsFromWareHouse;

}
