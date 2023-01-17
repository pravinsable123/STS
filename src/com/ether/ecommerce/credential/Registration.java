package com.ether.ecommerce.credential;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import com.ether.ecommerce.customexception.InvalidEmailId;
import com.ether.ecommerce.customexception.InvalidMobileNumber;
import com.ether.ecommerce.customexception.UserAlreadyExist;
import com.ether.ecommerce.dbconnection.DataBaseImpl;

public class Registration {

	private static Connection connection=null;
	private static PreparedStatement preparedstatement=null;
	Map<String, String> map;
	private int status;
	public void registration() {
		
		try {
			DataBaseImpl databaseimpl = new DataBaseImpl();
			connection=databaseimpl.getConnection();
			preparedstatement = connection.prepareStatement("select username, mobnum from userreg");
			ResultSet resultset = preparedstatement.executeQuery();
			map = new LinkedHashMap<String, String>();
			while(resultset.next()) {
				map.put(resultset.getString(1), resultset.getString(2));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		String name=null;
		String username=null;
		String password=null;
		String address=null;
		String emailid=null;
		String mobnum=null;

		Scanner scanner = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);
		Scanner scanner3 = new Scanner(System.in);
		Scanner scanner4 = new Scanner(System.in);
		Scanner scanner5 = new Scanner(System.in);
		boolean b=true;
		while(b) {
			System.out.println("Please Enter User Name of your choice (Case Sensitive) ");
			username = scanner.nextLine();
			boolean me=true;
			while(me) {
				System.out.println("Please Enter your Mobile Number without country code ");
				mobnum=scanner2.nextLine();
				try {
					int count=0;
					for(int i=0;i<mobnum.length();i++) {
						if(!(mobnum.charAt(i)>=48 && mobnum.charAt(i)<=57)) {
							count++;
						}	
					}
					if(count!=0|| !(mobnum.length()==10)) {
							throw new InvalidMobileNumber("Invalid Mobile Number");
						}
						else {
							me=false;
						}
				}
				catch(Exception e) {
					System.out.println(e);
				}
			}
			if(map.containsKey(username) || map.containsValue(mobnum)) {
				try {
				throw new UserAlreadyExist("Username or Mobile Number already exits. Please try with different username / Mobile Number");
				}catch(Exception e) {
					System.out.println(e);
				} catch (UserAlreadyExist e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
			else {
				b=false;
			}	
		}
		System.out.println("Please Enter your Name ");
		name = scanner3.nextLine();
		
		System.out.println("Please Enter password of your choice (Case Sensitive)");
		password=scanner4.nextLine();
		
		boolean ad=true;
		while(ad) {
			Scanner scad = new Scanner(System.in);
			System.out.print("Please Enter delivery address ");
			address = scad.nextLine();
			if(address.length()<=0) {
				System.out.println("Invalid address");
			}
			else {
				ad=false;
			}
		}
		
		boolean em=true;
		while(em) {
			System.out.println("Please Enter your email-id");
			emailid=scanner.nextLine();
			try {
				if(!(emailid.substring(emailid.length()-4).equals(".com")) || !(emailid.contains("@"))) {
					throw new InvalidEmailId("Entered email id is invalid");
				}
				else {
					em=false;
				}
			}
			catch(Exception e) {
				System.out.println(e);	
			}
		}
		try {
			preparedstatement = connection.prepareStatement("insert into userreg (username, name, mobnum, password, address, emailid)values(?,?,?,?,?,?)");
			preparedstatement.setString(1, username );
			preparedstatement.setString(2, name );
			preparedstatement.setString(3, mobnum );
			preparedstatement.setString(4, password );
			preparedstatement.setString(5, address );
			preparedstatement.setString(6, emailid );
		
			status = preparedstatement.executeUpdate();
			if(status==1) {
				System.out.println("Dear user you are successfully registered. Please restart app and login..");
				
			}
			scanner.close();
			scanner2.close();
			scanner3.close();
			scanner4.close();
			scanner5.close();
			connection.close();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	public int getRegStatus() {
		return status;
	}
}
