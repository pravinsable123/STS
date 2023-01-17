package com.ether.ecommerce.product;

public class ProductImpl {

	private int productId;
	private String ProductName;
	private String Description;
	private int price;
	private int AvailableQty;
	public ProductImpl(int productId, String productName, String description, int price, int availableQty) {
	
		this.productId = productId;
		this.ProductName = productName;
		this.Description = description;
		this.price = price;
		this.AvailableQty = availableQty;
	}
	public ProductImpl() {
	
	}
	@Override
	public String toString() {
		return "ProductImpl [productId=" + productId + ", ProductName=" + ProductName + ", Description=" + Description
				+ ", price=" + price + ", AvailableQty=" + AvailableQty + "]";
	}
	public int getProductId() {
		return productId;
	}
	public String getProductName() {
		return ProductName;
	}
	public String getDescription() {
		return Description;
	}
	public int getPrice() {
		return price;
	}
	public int AvailableQty() {
		return AvailableQty;
	}
	
	
	
}
