package com.ether.ecommerce.product;

import com.ether.ecommerce.user.Guest;

public class ProductCanon {
	
	public void getCanonPrinterDesc() {
		ProductImpl canon = Guest.getAscProductList().get(2);
		System.out.println("Product : "+canon.getProductName());
		System.out.println("Description : "+canon.getDescription());
		System.out.println("Price Rs : "+canon.getPrice());
		
	}

}
