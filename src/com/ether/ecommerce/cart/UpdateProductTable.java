package com.ether.ecommerce.cart;

public class UpdateProductTable {

	int ProductId;
	int cartqty;
	int newqty;
	public UpdateProductTable(int ProductId, int cartqty,int newqty) {
		this.ProductId=ProductId;
		this.cartqty=cartqty;
		this.newqty=newqty;
		
		
	}
	
	public String toString() {
		return "UpdateProductTable [ProductId=" + ProductId + ", cartqty=" + cartqty + ", newqty=" + newqty + "]";
		
	}

	public int getProductId() {
		return ProductId;
	}

	public int getCartqty() {
		return cartqty;
	}

	public int getNewqty() {
		return newqty;
	}
	
	
	
	

}
