package com.tavant.searchAddress.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PasswordNotMatchException extends Exception{
	
	public PasswordNotMatchException(String message) {
		super(message);
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + this.getMessage();
	}

}
