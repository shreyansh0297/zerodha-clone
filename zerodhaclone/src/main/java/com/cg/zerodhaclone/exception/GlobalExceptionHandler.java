package com.cg.zerodhaclone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
    public ErrorMessage userNameNotFound(Exception e) {
    	return new ErrorMessage(HttpStatus.NOT_FOUND,e.getMessage());
    }	
	
	@ExceptionHandler(EmailAlreadyExistsException.class)
	public ErrorMessage emailAlreadyExists(Exception e) {
		return new ErrorMessage(HttpStatus.CONFLICT,e.getMessage());
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
    public ErrorMessage handleAllExceptions(Exception e) {
   	return new ErrorMessage(
   			HttpStatus.INTERNAL_SERVER_ERROR,"Something went wrong");
   }
	
}
