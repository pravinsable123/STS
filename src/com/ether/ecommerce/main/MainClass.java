package com.ether.ecommerce.main;

import java.util.Scanner;

import com.ether.ecommerce.credential.LoginPage;
import com.ether.ecommerce.credential.Registration;
import com.ether.ecommerce.user.Guest;
import com.ether.ecommerce.user.LoginUser;

public class MainClass {
public static void mainPage() {
		
		System.out.println(">>>>>>>"+ "WELCOME TO ETHERCART"+"<<<<<<<"+"\n");

		boolean b = true;
		while(b) {
			Scanner sc = new Scanner(System.in);
			System.out.println("--->>"+"Please Select your choice"+"<<---");
			System.out.println("    "+"Select 1--->> To Register");
			System.out.println("    "+"Select 2--->> To Login");
			System.out.println("    "+"Select 3--->> Continue as Guest");
			System.out.println("    "+"Select 4--->> To Exit App");
			int choice=0;
			try {
			 choice = sc.nextInt();
			}
			catch(Exception e) {
				System.out.println("Invalid Input");
				
			}
		
			switch(choice) {
			case 1:
				Registration user = new Registration();
				user.registration();
				b=false;
				break;
				
			case 2:
				LoginPage loginpage = new LoginPage();
				String loginuser=loginpage.makeLogin();
				if(loginpage.getLoginStatus()==1) {
					new LoginUser(loginuser).showDescription(loginuser);
					b=false;
				}
				else
					b=false;
				break;
				
			case 3:
				Guest guest = new Guest();
				guest.showDescription(guest.getusername());
				b=false;
				break;
			case 4:
				System.out.println("Thank You for Shopping with us. Have a great day! ");
				b=false;
				break;
			default :
					System.out.println("Please select a valid Option...\n");
			}
			}
		}
	
	public static void main(String [] args) {
		
		mainPage();
	}
}
