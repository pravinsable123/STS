package com.ether.ecommerce.product;

import com.ether.ecommerce.user.Guest;

public class ProductCasio {
	
	public void getCasioWatchDesc() {
		ProductImpl casio = Guest.getAscProductList().get(3);
		System.out.println("Product : "+casio.getProductName());
		System.out.println("Description : "+casio.getDescription());
		System.out.println("Price Rs : "+casio.getPrice());
		
	}

}

