package com.ether.ecommerce.product;

import com.ether.ecommerce.user.Guest;

public class ProductVoltas {
	
	public void getVoltasACDesc() {
		ProductImpl voltas = Guest.getAscProductList().get(9);
		System.out.println("Product : "+voltas.getProductName());
		System.out.println("Description : "+voltas.getDescription());
		System.out.println("Price Rs : "+voltas.getPrice());
		
	}

}

