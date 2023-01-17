package com.ether.ecommerce.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.ether.ecommerce.cart.Cart;
import com.ether.ecommerce.cart.CartList;
import com.ether.ecommerce.cart.UpdateCart;
import com.ether.ecommerce.cart.UpdateProductTable;
import com.ether.ecommerce.customexception.InvalidQuantity;
import com.ether.ecommerce.dbconnection.DataBaseImpl;
import com.ether.ecommerce.dbconnection.MyConnection;
import com.ether.ecommerce.main.MainClass;

public class LoginUser extends Guest implements Cart {
	
	Connection connection;
	PreparedStatement preparedstatement;
	
	public LoginUser(String username) {
		this.username=username;
	}
	
	public LoginUser() {
		super();
	}
	
	
	public void displayAddedItem() {}
	
	String username=null;
	int productid=0;
	int availableqty=0;
	int price = 0;
	int buyqty=0;
	String productname=null;
	
	public void addToCart(Map<String, Integer> map) {
		
		Set<String> set = map.keySet();
		Iterator<String> itr = set.iterator();
		while(itr.hasNext()) {
			username=(String) itr.next();
			productid=map.get(username);
		}
		
		try {
			
			DataBaseImpl databaseimpl = new DataBaseImpl();
			connection=databaseimpl.getConnection();
			preparedstatement = connection.prepareStatement("select Name ,quantity, Price from productlist where ProductId=?");
			preparedstatement.setInt(1, productid);
			ResultSet resultset = preparedstatement.executeQuery();
			while(resultset.next()) {
				productname = resultset.getString(1);
				availableqty=resultset.getInt(2);
				price = resultset.getInt(3);
			}
			//System.out.println(availableqty+" "+price+" "+productname);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		checkQuantity();
		
		boolean be=true;
		while(be) {
			try {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Select 1--->> Go to Cart");
				System.out.println("Select 2--->> Go to Product List to add more");
				System.out.println("Select 3--->> Log Out");
				int choice = scanner.nextInt();
				switch(choice) {
				case 1:
					goToCart();
					be=false;
					break;
				case 2:
					new LoginUser(username).showDescription(username);
					be=false;
					break;
					
				case 3:
					MainClass.mainPage();
					be=false;
					break;
					
				default:
					System.out.println("Please select a valid number");
				}
			}
			catch(Exception e) {
				
			}	
		}			
	}
	
	public void deleteItem() {
		int choice=0;
		boolean a=true;
		while(a) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter Product Id number to Delete ");
			try {
				choice = scanner.nextInt();
				a=false;
			}
			catch(Exception e) {
				System.out.println("Invalid Input ");
			}
		}
		if(username!=null ) {
			try {
				preparedstatement =connection.prepareStatement("delete from usercart where UserName=? AND ProductId=?");
				preparedstatement.setString(1, username);
				preparedstatement.setInt(2, choice);
				int i =preparedstatement.executeUpdate();	
				if(i==1) {
					System.out.println("Item Deleted Successfully ");
				}
			}
			catch(Exception e) {
				System.out.println("Enter a valid Product Id");
			}
		}
		else {
			System.out.println("User Id not available");
		}
		
		System.out.println();
	}
	
	public void editQuantity() {
		
	}
	
	public void goToCartOptions() {
		boolean d=true;
		while(d) {
			int choice1=0;
			Scanner scanner1 = new Scanner(System.in);
			System.out.println("Select 1--->> Delete an Item from Cart ");
			//System.out.println("Select 2--->> Edit quantity ");
			System.out.println("Select 2--->> Proceed to Checkout ");
			System.out.println("Select 3--->> Add More Product ");
			System.out.println("Select 4--->> View Orders ");
			System.out.println("Select 5--->> Sign Out ");
			try {
				choice1 = scanner1.nextInt();
			}
			catch(Exception e) {
				System.out.println("Invalid Input ");
			}
			switch(choice1) {
			
				case 1:
					deleteItem();
					goToCart();
					d=false;
					break;
				
					/*case 2:
					editQuantity();
					d=false;*/
				
				case 2:
					checkout();
					new LoginUser(username).showDescription(username);
					d=false;					
					break;
					
				case 3:
					new LoginUser(username).showDescription(username);
					d=false;
					break;
					
				case 4: 
					viewOrders();
					goToCartOptions();
					d=false;
					break;
				
				case 5:
					MainClass mainclass= new MainClass();
					mainclass.mainPage();
					d=false;
					break;
				
				default:
					System.out.println("Please enter the valid number");
			
			}
		}
		
	}
		
	public void viewOrders() {
		try {
			Connection connectionview = MyConnection.getConnection();
			PreparedStatement preparedstatementorder = connectionview.prepareStatement("select ProductName, Quantity, CartValue from orderplaced where UserName=?");
			preparedstatementorder.setString(1, username);
			ResultSet resultsetplacedorder = preparedstatementorder.executeQuery();
			int i=0;
			while(resultsetplacedorder.next()) {
				i++;
				System.out.println(i+"  "+"Product : "+resultsetplacedorder.getString(1)+"  "+"Quantity : "+resultsetplacedorder.getInt(2)+"  "+"Buying Value Rs : "+resultsetplacedorder.getInt(3));
			}
			System.out.println();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	
	public void goToCart() {	
		int total=0;
		
		try {
			//System.out.println(username);--for error inspection
			PreparedStatement preparedstatement1= connection.prepareStatement("select ProductId, ProductName, Qty, CartValue from usercart where UserName = ?");
			preparedstatement1.setString(1, username);
			ResultSet resultset = preparedstatement1.executeQuery();
			List<CartList> list = new ArrayList<CartList>();
			while(resultset.next()) {
			//	System.out.println(resultset.getInt(1)+" "+resultset.getString(2)+" "+ resultset.getInt(3)+" "+resultset.getInt(4));--for error inspection
				list.add(new CartList(resultset.getInt(1),resultset.getString(2), resultset.getInt(3),resultset.getInt(4)));
			}
			//System.out.println(list);---for error inspection
			Iterator<CartList> itr = list.iterator();
			while(itr.hasNext()) {
				CartList cartlist = itr.next();
				int sum=cartlist.getCartValue();
				total=sum+total;
				System.out.print("--->>Product Id : "+cartlist.getId()+"--->> Product Name : "+cartlist.getProductName()+"--->> Quantity : "+ cartlist.getQty()+" >>> Total :"+sum+"\n");
			}
			System.out.println("------->>>>>Grand Total is : "+ total+"<<<<<-------"+"\n");
					
			goToCartOptions();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

	public void checkout() {
		
		try {
			Connection connectionorder = MyConnection.getConnection();
			
			PreparedStatement preparedstatementoder= connectionorder.prepareStatement("SELECT usercart.ProductId, usercart.Qty, productlist.quantity FROM usercart INNER JOIN productlist ON usercart.ProductId=productlist.ProductId where usercart.UserName=?");
			preparedstatementoder.setString(1, username);
			ResultSet resultsetupdate=preparedstatementoder.executeQuery();
			List<UpdateProductTable> updateproductlist = new ArrayList<UpdateProductTable>();
			while(resultsetupdate.next()) {
				updateproductlist.add(new UpdateProductTable (resultsetupdate.getInt(1),resultsetupdate.getInt(2),resultsetupdate.getInt(3)));
			}
			
			Iterator<UpdateProductTable> itrupdate= updateproductlist.iterator();
			while(itrupdate.hasNext()) {
				UpdateProductTable upt = itrupdate.next();
				int diff=upt.getNewqty()-upt.getCartqty();
				preparedstatementoder= connectionorder.prepareStatement("update productlist SET quantity=? WHERE ProductId=?");
				preparedstatementoder.setInt(1, diff);
				preparedstatementoder.setInt(2, upt.getProductId());
				preparedstatementoder.executeUpdate();		
			}
				
			preparedstatementoder=connectionorder.prepareStatement("insert into orderplaced (UserName, ProductId, ProductName, Quantity , CartValue) select * from usercart where UserName=?");
			preparedstatementoder.setString(1, username);
			int i =preparedstatementoder.executeUpdate();
			if(i!=0) {
				System.out.println("Congratulations!! Your order is placed successfully");
				System.out.println("They will reach you within 4 working days");				
			}
						
			preparedstatementoder=connectionorder.prepareStatement("delete from usercart where UserName=?");
			preparedstatementoder.setString(1, username);
			preparedstatementoder.executeUpdate();
		
		}
		catch(Exception e) {
			System.out.println(e); //"Failed to Connect to database"
		}
	}	
	
	public void checkQuantity() {
		boolean b = true;
		
		while(b) {
			try {
				System.out.println("Please enter the quantity to buy ");
				Scanner scanner = new Scanner(System.in);
				try {
					buyqty=scanner.nextInt();
				}
				catch(Exception e) {
					System.out.println(e);
				}
				if(buyqty<=0|buyqty>availableqty) {
						if(buyqty<=0) {
						throw new InvalidQuantity("Entered Quantity is Invalid. Please enter valid quantity");
					}
				
					if(buyqty>availableqty) {
						throw new InvalidQuantity("Product Outof Stock. Entered Quantity in more then available stock, maximum quantity available is "+availableqty);
					}
				}
				else
				{
					int count=0;
					PreparedStatement preparedstatement2 =connection.prepareStatement("select UserName from usercart");
					ResultSet set=preparedstatement2.executeQuery();
					while(set.next()) {
						if(username.equals(set.getString(1))) {
							count++;
						}
					}
							
					if(count!=0) {
						PreparedStatement preparedstatement3= connection.prepareStatement("select ProductName, Qty, Cartvalue from usercart where UserName =?");
						preparedstatement3.setString(1, username);
						ResultSet resultset = preparedstatement3.executeQuery();
						List<UpdateCart> orderlist = new ArrayList<UpdateCart>();
						while(resultset.next()) {
							orderlist.add(new UpdateCart(resultset.getString(1), resultset.getInt(2), resultset.getInt(3)));
						}
						Iterator<UpdateCart> itrorder = orderlist.iterator();
						int countp=0;
						int currentqty=0;
						int currentvalue=0;
						while(itrorder.hasNext()) {
							UpdateCart uc =itrorder.next();
							String orderpname=uc.getProductName();
							if(orderpname.equals(productname)) {
								currentqty=uc.getQty();
								currentvalue=uc.getCartvalue();
								countp++;
							}	
						}
					
						if(countp!=0) {
							PreparedStatement preparedstatement4=connection.prepareStatement("update usercart SET Qty=?, CartValue=? where UserName =? AND ProductName =?");
							int summ=currentqty+buyqty;
							int updatevalue = (currentvalue/currentqty)*summ;
							//System.out.println("New updated qty is cart is "+summ+" "+" avaialble "+" "+map.get(productname)+" "+ "new added "+buyqty);--for error inspection
							preparedstatement4.setInt(1, summ);
							preparedstatement4.setInt(2, updatevalue);
							preparedstatement4.setString(3, username);
							preparedstatement4.setString(4, productname);
							int i =preparedstatement4.executeUpdate();
							if(i==1) {
								System.out.println("Cart updated successfully");
							}
						}
						
						else {
							Class.forName("com.mysql.jdbc.Driver");
							Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/etherdb","root","prashant");
							PreparedStatement preparedstatement5=connection1.prepareStatement("insert into usercart(UserName, ProductId, ProductName ,Qty, CartValue)values(?,?,?,?,?)");
							preparedstatement5.setString(1, username);
							preparedstatement5.setInt(2, productid);
							preparedstatement5.setString(3, productname);
							preparedstatement5.setInt(4, buyqty);
							preparedstatement5.setInt(5, price*buyqty);
							int i=preparedstatement5.executeUpdate();
							if(i==1) {
							System.out.println("Product added to cart successfully");
							}							
						}
					}
					
					else {	
						Class.forName("com.mysql.jdbc.Driver");
						Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/etherdb","root","prashant");
		
						PreparedStatement preparedstatement5=connection1.prepareStatement("insert into usercart(UserName, ProductId, ProductName ,Qty, CartValue)values(?,?,?,?,?)");
						preparedstatement5.setString(1, username);
						preparedstatement5.setInt(2, productid);
						preparedstatement5.setString(3, productname);
						preparedstatement5.setInt(4, buyqty);
						preparedstatement5.setInt(5, price*buyqty);
						int i=preparedstatement5.executeUpdate();
						if(i==1) {
						System.out.println("Product added to cart successfully");
						}
					}
					b=false;
				}
			
			}catch (Exception e) {
				System.out.println(e);
			}
		}	
	}
}

