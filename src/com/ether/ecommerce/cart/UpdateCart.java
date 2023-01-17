package com.ether.ecommerce.cart;

public class UpdateCart {
 String ProductName;
 int Qty;
 int Cartvalue;
 
 public UpdateCart(String ProductName, int Qty,	int Cartvalue) {
		this.ProductName=ProductName;
		this.Qty=Qty;
		this.Cartvalue=Cartvalue;
	}
 

@Override
public String toString() {
	return "UpdateCart [ProductName=" + ProductName + ", Qty=" + Qty + ", Cartvalue=" + Cartvalue + "]";
}


public String getProductName() {
	return ProductName;
}

public int getQty() {
	return Qty;
}

public int getCartvalue() {
	return Cartvalue;
}
 
}
