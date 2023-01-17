package com.ether.ecommerce.product;

import com.ether.ecommerce.user.Guest;

public class ProductBosch extends ProductImpl{
	
	public void getBOSCHDishwasherDesc() {
		
		ProductImpl bosch = Guest.getAscProductList().get(1);
		System.out.println("Product : "+bosch.getProductName());
		System.out.println("Description : "+bosch.getDescription());
		System.out.println("Price Rs : "+bosch.getPrice());
		
	}

}

