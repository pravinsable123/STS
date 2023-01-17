package com.ether.ecommerce.customexception;
public class OutofStock extends RuntimeException{
	
	public OutofStock(String message) {
		super(message);
	}

}

