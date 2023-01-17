package com.ether.ecommerce.product;

import com.ether.ecommerce.user.Guest;

public class ProductNikon {
	
	public void getNikonDSLRDesc() {
		ProductImpl nikon = Guest.getAscProductList().get(7);
		System.out.println("Product : "+nikon.getProductName());
		System.out.println("Description : "+nikon.getDescription());
		System.out.println("Price Rs : "+nikon.getPrice());
	}

}
