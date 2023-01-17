package com.ether.ecommerce.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ether.ecommerce.dbconnection.MyConnection;

public class AdminAcess implements Admin{
	private Connection connection;
	private PreparedStatement preparedstatement;
	
	public void getRegUserList() {
		try {
			connection=MyConnection.getConnection();
			preparedstatement = connection.prepareStatement("select username, name, mobnum from userreg");
			ResultSet resultset =preparedstatement.executeQuery();
			System.out.println("Registered User Details are : ");
			while(resultset.next()) {
				System.out.println("--->> Username : "+resultset.getString(1)+"  --->> Name : "+resultset.getString(2)+"  --->> Mobile Number : "+resultset.getString(3));		
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void getProductQtyList() {
		try {
			connection=MyConnection.getConnection();
			preparedstatement = connection.prepareStatement("select ProductId from productlist");
			ResultSet resultset =preparedstatement.executeQuery();
			List<Integer> productidlist = new ArrayList<Integer>();
			while(resultset.next()) {
				productidlist.add(resultset.getInt(1));
			}
			int productid=0;			
			boolean check=true;
			while(check) {
				boolean b=true;
				while(b) {
					System.out.println("Please Enter the Product Id to check details ");
					Scanner scanner = new Scanner(System.in);
					try {
						productid = scanner.nextInt();
						b=false;
					}
					catch(Exception e) {
						System.out.println("XXX Invalid Input XXX");
					}
				}
				if(productidlist.contains(productid)) {
					preparedstatement = connection.prepareStatement("select Name , quantity from productlist where ProductId=?");
					preparedstatement.setInt(1, productid);
					ResultSet productdetails=preparedstatement.executeQuery();
					while(productdetails.next()) {
						System.out.println(" --->> Product Name : " + productdetails.getString(1)+" --->> Available Quantity : "+ productdetails.getString(2));
					}
					check=false;	
				}
				else {
					System.out.println("XXX Enter Product Id does not exist XXX");
				}				
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void getUserOrderHistory() {
		try {
			connection=MyConnection.getConnection();
			preparedstatement = connection.prepareStatement("select username from userreg");
			ResultSet resultset =preparedstatement.executeQuery();
			List<String> userlist = new ArrayList<String>();
			while(resultset.next()) {
				userlist.add(resultset.getString(1));
			}
			
			connection=MyConnection.getConnection();
			preparedstatement = connection.prepareStatement("select username from orderplaced");
			ResultSet resultset2 =preparedstatement.executeQuery();
			List<String> orderlist = new ArrayList<String>();
			while(resultset2.next()) {
				orderlist.add(resultset2.getString(1));
			}
			
			String username=null;			
			boolean check=true;
			while(check) {
				boolean b=true;
				while(b) {
					System.out.println("Please Enter the Username to check details ");
					Scanner scanner = new Scanner(System.in);
					try {
						username = scanner.nextLine();
						b=false;
					}
					catch(Exception e) {
						System.out.println("XXX Invalid Input XXX");
					}
				}
				
				if(userlist.contains(username)) {
					if(orderlist.contains(username)) {
						preparedstatement = connection.prepareStatement("select ProductName, Quantity, CartValue from orderplaced where UserName=?");
						preparedstatement.setString(1, username);
						ResultSet productdetails=preparedstatement.executeQuery();
						while(productdetails.next()) {
						System.out.println(" --->> Product Name : " + productdetails.getString(1)+" --->> Ordered Quantity : "+ productdetails.getString(2)+" --->> Order Value Rs :"+productdetails.getInt(3));
					}
						
				}
					else {
						System.out.println("This user has never buyed our product");
					}
					check=false;
				}
				else {
					System.out.println("XXX Username does not exist XXX");
				}				
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void getTotalOrderHistory() {
		try {
		connection=MyConnection.getConnection();
		preparedstatement = connection.prepareStatement("select * from orderplaced");
		ResultSet orderset =preparedstatement.executeQuery();
		while(orderset.next()) {
			System.out.println(" --->> Username : "+orderset.getString(1)+" --->> Product Id : "+orderset.getInt(2)+" --->> Product Name : "+orderset.getString(3)+" --->> Ordered Quantity : "+orderset.getInt(4)+" --->> Order Value : "+orderset.getInt(5));
		}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
	}
}
