package com.ether.ecommerce.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

	static private Connection connection;
	
	public static Connection getConnection()throws ClassNotFoundException,SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/etherdb","root","mysql@123");
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return connection;
		
	}
}
