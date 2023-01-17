package com.ether.ecommerce.user;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.ether.ecommerce.cart.Cart;
import com.ether.ecommerce.credential.LoginPage;
import com.ether.ecommerce.credential.Registration;
import com.ether.ecommerce.dbconnection.DataBaseImpl;
import com.ether.ecommerce.display.Display;
import com.ether.ecommerce.product.ProductComparator;
import com.ether.ecommerce.product.ProductImpl;

public class Guest extends ProductImpl implements Display, Cart {
	
	private List<ProductImpl> productlist;
	private String username="guest";
	
	public String getusername() {
		return username;
	}
	
	public Guest(){
		this.username="guest";
	}
	public void showProductList() {
		int i=0;
		for(ProductImpl p:setAscProductList()) {
			i++;
			System.out.println(i+" . --->> "+p.getProductName());
		}
	}
	
	public List<ProductImpl> setAscProductList(){
		DataBaseImpl databaseimpl = new DataBaseImpl();
		productlist =databaseimpl.getProductList();
		Collections.sort(productlist, new ProductComparator());
		return productlist;
	}
	
	public static List<ProductImpl> getAscProductList(){
		Guest displayproduct = new Guest();
		return displayproduct.setAscProductList();
			
	}

	
	public void addToCart(Map<String, Integer> map) {
		LoginPage login;
		String uname=null;
		int choice=0;
		boolean z=true;
		while(z) {
			System.out.println("Select 1--->> To Login");
			System.out.println("Select 2--->> To Register");
			Scanner scanner = new Scanner(System.in);
			try {
				choice = scanner.nextInt();
			}
			catch(Exception e) {
				System.out.println("Invalid Input");
			}
		
			switch(choice) {
			case 1: 
				login = new LoginPage();
				uname =login.makeLogin();
				new LoginUser(uname).showDescription(uname);
				z=false;
				break;
			
			case 2:
				Registration newuser = new Registration();
				newuser.registration();
				z=false;
				break;
				
			default : 
					System.out.println("Please enter valid number ");

			}
		}
		
	}
	

	public Map<String, Integer> showAdd_Goto_Cart(Map<String, Integer> map) {
		String username=null;
		Set<String> set = map.keySet();
		Iterator<String> itr = set.iterator();
		while(itr.hasNext()) {
			username=(String) itr.next();	
		}
		int choice=0;
		boolean b=true;
		while(b) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Select 1--->> for Previous Page");
			System.out.println("Select 2--->> To Add this Product to Cart");
			//System.out.println("Select 3--->> To Go to Cart");
			try {
				choice = scanner.nextInt();
			}catch(Exception e) {
				System.out.println("Invalid Input ");
			}
			
			switch(choice) {
		
			case 1:
				showDescription(username);
				b=false;
				break;
			
			case 2:
				addToCart(map);
				b=false;
				break;
			
			default: 
				System.out.println("Please select a valid number");
			}
		}
		return map;
	}	
	
	Scanner sc = new Scanner(System.in);
	
	public void showDescription(String username) {
		showProductList();
		System.out.println("11. Exit App ");
		
		System.out.println("Please Select Product Number for More Details : ");
		Map<String, Integer> map=new LinkedHashMap<String, Integer>();
		int choice=0; 
		boolean b = true;
		while(b) {
			Scanner sc = new Scanner(System.in);
			try {
				choice = sc.nextInt();
			}
			catch(Exception e) {
				System.out.println("Inalid Input");
			}
			
			switch(choice) {
			
			case 1:
			//	map=getAppleiPhoneDesc(username);
				showAdd_Goto_Cart(map);
				b=false;
				break;
				
			case 2:
				//map=getBOSCHDishwasherDesc(username);
				showAdd_Goto_Cart(map);
				b=false;
				break;
				
			case 3:
				//map=getCanonPrinterDesc(username);
				showAdd_Goto_Cart(map);
				b=false;
				break;
				
			case 4:
			//	map=getCasioWatchDesc(username);
				showAdd_Goto_Cart(map);
				b=false;
				break;
				
			case 5:
			//	map=getDellInspironDesc(username);
				showAdd_Goto_Cart(map);
				b=false;
				break;
				
			case 6:
				//map=getLGRefrigeratorDesc(username);
				showAdd_Goto_Cart(map);
				b=false;
				break;
				
			case 7:
				//map=getMiTVDesc(username);
				showAdd_Goto_Cart(map);
				b=false;
				break;
				
			case 8:
				//map=getNikonDSLRDesc(username);
				showAdd_Goto_Cart(map);
				b=false;
				break;
				
			case 9:
				//map=getSamsungGalaxyDesc(username);
				showAdd_Goto_Cart(map);
				b=false;
				break;
				
			case 10:
				//map=getVoltasACDesc(username);
				showAdd_Goto_Cart(map);
				b=false;
				break;
				
			case 11:
				System.out.println("Thank You for Shopping with us. Have a great Day!");
				b=false;
				break;
				
			default :
				System.out.println("Please select a valid number :");
			}
		}
	}
	
}
	

