package com.ether.ecommerce.product;

import java.util.Comparator;

public class ProductComparator implements Comparator<ProductImpl> {

	
	public int compare(ProductImpl p1, ProductImpl p2) {
		return p1.getProductName().compareTo(p2.getProductName());
		
	} 
}


