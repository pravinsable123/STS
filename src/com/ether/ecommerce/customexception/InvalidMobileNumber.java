package com.ether.ecommerce.customexception;

public class InvalidMobileNumber extends RuntimeException {
public	InvalidMobileNumber(String message){
		super(message);
	}
}
