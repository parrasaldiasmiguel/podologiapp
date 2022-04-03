package com.podologia.backend.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> manejarTodasExcepciones(ModelExceptionHandler ex, WebRequest request ) {
		ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(er, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ModelExceptionHandler.class)
	public final ResponseEntity<ExceptionResponse> driveModelException(ModelExceptionHandler err, WebRequest request){
		ExceptionResponse response = new ExceptionResponse(LocalDateTime.now(),err.getMessage(),request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders header , HttpStatus status, WebRequest request){
		ExceptionResponse response = new ExceptionResponse(LocalDateTime.now(),ex.getMessage(), request.getDescription(false));		
	return new ResponseEntity<Object>(response,HttpStatus.BAD_REQUEST);
	}
	

}
