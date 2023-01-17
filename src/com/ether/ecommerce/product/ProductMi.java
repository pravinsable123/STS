package com.ether.ecommerce.product;

import com.ether.ecommerce.user.Guest;

public class ProductMi {
	
	public void getMiTVDesc() {
		ProductImpl mi = Guest.getAscProductList().get(6);
		System.out.println("Product : "+mi.getProductName());
		System.out.println("Description : "+mi.getDescription());
		System.out.println("Price Rs : "+mi.getPrice());
		
	}

}
