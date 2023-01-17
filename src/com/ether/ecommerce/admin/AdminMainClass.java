package com.ether.ecommerce.admin;

import java.util.Scanner;

public class AdminMainClass {

	
	public static void main(String[] args) {
		AdminAcess adminaccess = new AdminAcess();
		System.out.println(">>>>>>>WELCOME<<<<<<<");
		boolean b = true;
		while (b) {
			System.out.println("Select 1--->> To Get Registered User List");
			System.out.println("Select 2--->> To Get Product Quantity using Product Id");
			System.out.println("Select 3--->> To Get User Order History using Username");
			System.out.println("Select 4--->> To Get all Users Order History ");
			System.out.println("Select 5--->> To Exit App ");
			System.out.println();
			System.out.println("Please Select a Number");
			Scanner scanner = new Scanner(System.in);
			int choice = 0;
			try {
				choice = scanner.nextInt();
			} catch (Exception e) {
				System.out.println("XX Invalid Input XX");
			}

			switch (choice) {

			case 1:
				System.out.println();
				adminaccess.getRegUserList();
				System.out.println();
				break;

			case 2:
				System.out.println();
				adminaccess.getProductQtyList();
				System.out.println();
				break;

			case 3:
				System.out.println();
				adminaccess.getUserOrderHistory();
				System.out.println();
				break;

			case 4:
				System.out.println();
				adminaccess.getTotalOrderHistory();
				System.out.println();
				break;

			case 5:
				System.out.println();
				System.out.println("Thank You!! Have a Great Day...");
				System.out.println();
				b = false;
				break;

			default:
				System.out.println();
				System.out.println("Please Enter Valid Number " + "\n");
			}

		}

	}
}
