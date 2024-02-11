package br.com.erudio.exceptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.erudio.exceptions.ExcetionResponse;
import br.com.erudio.exceptions.UnsupportedMathOperationException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExcetionResponse> handleAllExceptions(
			Exception ex, WebRequest request) {
		ExcetionResponse excetionResponse = new ExcetionResponse(
				new Date(),
				ex.getMessage(),
				request.getDescription(false));
				return new ResponseEntity<>(excetionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(UnsupportedMathOperationException.class)
	public final ResponseEntity<ExcetionResponse> handleBadRequestExceptions(
			Exception ex, WebRequest request) {
		ExcetionResponse excetionResponse = new ExcetionResponse(
				new Date(),
				ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(excetionResponse, HttpStatus.BAD_REQUEST);
	}
}
