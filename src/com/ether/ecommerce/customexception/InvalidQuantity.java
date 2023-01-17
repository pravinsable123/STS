package com.ether.ecommerce.customexception;

public class InvalidQuantity extends RuntimeException {
	
	public InvalidQuantity(String message){
		super(message);
	}
	

}

