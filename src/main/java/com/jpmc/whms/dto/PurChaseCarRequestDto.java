/**
 * 
 */
package com.jpmc.whms.dto;

import java.math.BigDecimal;

import lombok.Data;
import lombok.ToString;

/**
 * @author madhukargunda
 *
 */
@Data
@ToString
public class PurChaseCarRequestDto {

	private Long id;

	private BigDecimal finalPrice;
}
