package com.restaurant.ingredients.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException {
	
	@ExceptionHandler(value = ExternalServiceException.class)
	public ResponseEntity<ErrorDTO> handleExternalServiceException(ExternalServiceException e) {
		ErrorDTO response = new ErrorDTO();
		ErrorResponse error = buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		response.setError(error);
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = BadRequestException.class)
	public ResponseEntity<ErrorDTO> handleBadRequestException(BadRequestException e) {
		ErrorDTO response = new ErrorDTO();
		ErrorResponse error = buildErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
		response.setError(error);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<ErrorDTO> handleNotFoundException(NotFoundException e) {
		ErrorDTO response = new ErrorDTO();
		ErrorResponse error = buildErrorResponse(HttpStatus.NOT_FOUND, e.getMessage());
		response.setError(error);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	private ErrorResponse buildErrorResponse(HttpStatus httpStatus, String message) {
		ErrorResponse error = new ErrorResponse();
		error.setHttpStatusCode(httpStatus.value());
		error.getDescription().add(message);
		error.setTimestamp(LocalDateTime.now());
		return error;
	}
}
