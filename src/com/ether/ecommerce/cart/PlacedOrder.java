package com.ether.ecommerce.cart;

public class PlacedOrder {

	String username;
	int id;
	String ProductName;
	int Qty;
	int CartValue;
	public PlacedOrder(String username, int id, String ProductName, int Qty, int CartValue) {
		this.username=username;
		this.id=id;
		this.ProductName=ProductName;
		this.Qty=Qty;
		this.CartValue=CartValue;
	}
	@Override
	public String toString() {
		return "PlacedOrder [username=" + username + ", id=" + id + ", ProductName=" + ProductName + ", Qty=" + Qty
				+ ", CartValue=" + CartValue + "]";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public int getQty() {
		return Qty;
	}
	public void setQty(int qty) {
		Qty = qty;
	}
	public int getCartValue() {
		return CartValue;
	}
	public void setCartValue(int cartValue) {
		CartValue = cartValue;
	}
	
}
