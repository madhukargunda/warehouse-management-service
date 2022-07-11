package com.jpmc.whms.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CartoWareHouseResponseDto extends CartoWareHouseRequestDto {

	private Long id;

}
