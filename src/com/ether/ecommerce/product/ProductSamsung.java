package com.ether.ecommerce.product;

import com.ether.ecommerce.user.Guest;

public class ProductSamsung {
	
	public void getSamsungGalaxyDesc() {
		ProductImpl samsung = Guest.getAscProductList().get(8);
		System.out.println("Product : "+samsung.getProductName());
		System.out.println("Description : "+samsung.getDescription());
		System.out.println("Price Rs : "+samsung.getPrice());
		
	}

}

