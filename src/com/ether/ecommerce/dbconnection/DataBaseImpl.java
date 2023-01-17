package com.ether.ecommerce.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ether.ecommerce.product.ProductImpl;

public class DataBaseImpl implements DataBase {
	
	private static Connection connection1;
	private static PreparedStatement preparedStatement;
	private ResultSet resultSet;
	List<ProductImpl> productlist;
	

	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			connection1=DriverManager.getConnection("jdbc:mysql://localhost:3306/etherdb","root","mysql@123");
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return connection1;
	}

	@Override
	public List<ProductImpl> getProductList() {
		
		return null;
	}

}
