package com.ether.ecommerce.credential;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import com.ether.ecommerce.dbconnection.DataBaseImpl;
import com.ether.ecommerce.main.MainClass;

public class LoginPage {
	private int login=0;
	String username;
	String password;
	Connection connection;
	PreparedStatement preparedstatement;
	
	public int getLoginStatus() {
		return login;
	}
	
	public String makeLogin()  {
		try {
		DataBaseImpl databaseimpl = new DataBaseImpl();
		connection=databaseimpl.getConnection();
		preparedstatement = connection.prepareStatement("select username, password from userreg");
		ResultSet resultset = preparedstatement.executeQuery();
		Map<String, String> map = new LinkedHashMap<String, String>();
		while(resultset.next()) {
			map.put(resultset.getString(1), resultset.getString(2));	
		}
	
		Scanner scanner=new Scanner(System.in);
		Scanner scanner1=new Scanner(System.in);
		
		boolean b = true;
		while(b) {
						
			System.out.println("Enter User Name ");
			username =scanner.nextLine();
			System.out.println("Enter Password ");
			password = scanner1.nextLine();
			if(map.containsKey(username)) {
				//System.out.println(map.get(username));
				if(map.get(username).equals(password)) {
					System.out.println("Login In Successful");
					login=1;
					b=false;
					return username;
				}
				else {
					System.out.println("Invalid Password");
					MainClass.mainPage();
					b=false;
				}	
			}
			else {
				System.out.println("Invalid User Name ");
				MainClass.mainPage();
				b=false;
				/*int choice=0;
				boolean m=true;
				while(m) {
					System.out.println("1. Try Again");
					System.out.println("2. Go to Home Page");
					Scanner scanner3  = new Scanner(System.in);
					try {
						choice = scanner3.nextInt();
					}
					catch (Exception e) {
						System.out.println("Invalid Input");
					}
					switch(choice) {
				
					case 1: 
						makeLogin();
						m=false;
						break;
					
					case 2:
						MainClass mainclass = new MainClass();
						mainclass.mainPage();
						m=false;
						break;
					
					default :
						System.out.println("Select a valid number : ");		
					}
				}*/				
			}
		}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return username;
	}
}
