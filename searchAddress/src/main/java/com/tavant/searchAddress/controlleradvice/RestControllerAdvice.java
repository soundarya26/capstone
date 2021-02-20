package com.tavant.searchAddress.controlleradvice;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.tavant.searchAddress.errorresponse.ErrorResponse;
import com.tavant.searchAddress.exceptions.AccountNotExistsException;



@ControllerAdvice
public class RestControllerAdvice {
	
	
	
		@ExceptionHandler(AccountNotExistsException.class)
		public final ResponseEntity<ErrorResponse> 
		handleAccountNotExistsException(AccountNotExistsException e,WebRequest request) {
			List<String> details = new ArrayList<String>();
			details.add(e.getLocalizedMessage());
			
			ErrorResponse errorResponse = new ErrorResponse("INCORRECT REQUEST",details);
			return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
		}

}
