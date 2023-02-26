package com.api.project.resources.exceptions;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.api.project.service.exceptions.DataIntegrityViolationException;
import com.api.project.service.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException ex, HttpServletRequest request) {
		StandardError error = new StandardError(LocalDateTime.now(), 
										HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> 
		dataIntegrityViolationException(DataIntegrityViolationException ex, HttpServletRequest request) {
		StandardError error = new StandardError(LocalDateTime.now(), 
				HttpStatus.BAD_REQUEST.value(), ex.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
