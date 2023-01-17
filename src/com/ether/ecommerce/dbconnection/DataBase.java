package com.ether.ecommerce.dbconnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ether.ecommerce.product.ProductImpl;

public interface DataBase {

	public Connection getConnection()throws ClassNotFoundException,SQLException;
	
	public List<ProductImpl>getProductList();
}
