/**
 * 
 */
package com.jpmc.whms.entity;

import java.math.BigDecimal;
import java.time.Year;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author madhukargunda
 *
 */

@Data
@Entity
public class Car {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="MAKE")
	private Year make;
	
	@Column(name="MODEL")
	private String model;
	
	@Column(name="ORIGINAL_PRICE")
	private BigDecimal originalPrice;
	
	@Column(name="SOLD_STATUS")
	private boolean sold;
	
	@Column(name="FINAL_PRICE")
	private BigDecimal finalPrice;
	
	
}
