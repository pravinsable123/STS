package com.ether.ecommerce.product;

import com.ether.ecommerce.user.Guest;

public class ProductLg {
	
	public void getLGRefrigeratorDesc() {
		ProductImpl lg = Guest.getAscProductList().get(5);
		System.out.println("Product : "+lg.getProductName());
		System.out.println("Description : "+lg.getDescription());
		System.out.println("Price Rs : "+lg.getPrice());
	
	}

}
