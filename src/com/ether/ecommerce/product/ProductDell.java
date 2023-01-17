package com.ether.ecommerce.product;

import com.ether.ecommerce.user.Guest;

public class ProductDell {
	
	public void getDellInspironDesc() {
		ProductImpl dell = Guest.getAscProductList().get(4);
		System.out.println("Product : "+dell.getProductName());
		System.out.println("Description : "+dell.getDescription());
		System.out.println("Price Rs : "+dell.getPrice());
		
		
	}

}

