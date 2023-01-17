package com.ether.ecommerce.display;

import java.util.List;

import com.ether.ecommerce.product.ProductImpl;

public interface Display {
	public List<ProductImpl> setAscProductList();
	
	public void showProductList();
}
