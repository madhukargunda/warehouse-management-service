package com.jpmc.whms.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.jpmc.whms.dto.ApiError;
import com.jpmc.whms.exception.CarNotFoundException;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class WareHouseControllerAdvice {

	@ExceptionHandler(CarNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ApiError resourceNotFoundException(CarNotFoundException ex, WebRequest request) {
		log.info("Now triggering the Controller Advice method");
		return new ApiError(ex.getMessage());
	}

}
