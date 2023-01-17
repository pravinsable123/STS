package com.ether.ecommerce.cart;

public class CartList {

	int id;
	String ProductName;
	int Qty;
	int CartValue;
	@Override
	public String toString() {
		return "CartList [id=" + id + ", productName=" + ProductName + ", Qty=" + Qty + ", cartValue=" + CartValue
				+ "]";
	}
	public int getId() {
		return id;
	}
	public String getProductName() {
		return ProductName;
	}
	public int getQty() {
		return Qty;
	}
	public int getCartValue() {
		return CartValue;
	}
	public CartList(int id,String ProductName, int Qty, int CartValue) {
		this.id=id;
		this.ProductName=ProductName;
		this.Qty= Qty;
		this.CartValue=CartValue;
		
	}
	
}
