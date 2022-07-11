package com.jpmc.whms.dto;

import java.math.BigDecimal;
import java.time.Year;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CartoWareHouseRequestDto {

	@NotEmpty(message="description should not empty")
	private String description;

	@NotNull(message="car manufacture should not be empty")
	private Year make;

	@NotEmpty(message="car model should not be empty")
	private String model;

	@NotNull(message="car price should not be empty")
	private BigDecimal price;
	
	@NotNull
	private String name;

}
