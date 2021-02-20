package com.tavant.searchAddress.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AddressNotFoundException extends Exception{
	
	public AddressNotFoundException(String message) {
		super(message);
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + this.getMessage();
	}

}