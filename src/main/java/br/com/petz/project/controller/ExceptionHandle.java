package br.com.petz.project.controller;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.petz.project.response.ApiErrorResponse;

@RestControllerAdvice
public class ExceptionHandle {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ApiErrorResponse> entityNotFoundException(EntityNotFoundException ex) {
		return new ResponseEntity<>(ApiErrorResponse
									.builder()
									.code(HttpStatus.NOT_FOUND.value())
									.message(ex.getMessage()).build(),HttpStatus.NOT_FOUND);
				
	}

	@ExceptionHandler
	public ResponseEntity<ApiErrorResponse> handleException(Exception ex) {
		return new ResponseEntity<>(ApiErrorResponse
				.builder()
				.code(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.message(ex.getMessage()).build(),HttpStatus.INTERNAL_SERVER_ERROR);
				
				
			
	}

}
