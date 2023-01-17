package com.ether.ecommerce.display;

import java.util.Scanner;

public class Back_AddCart_GotoCart {
public void userSelection() {
		
		Scanner sc = new Scanner(System.in);
		boolean b = true;
		while(b) {
			System.out.println("Please Select your choice");
			System.out.println("1. Add to Cart");
			System.out.println("2. Go to Cart");
			System.out.println("3. Back");
			int choice=0;
			try {
			 choice = sc.nextInt();
			}
			catch(Exception e) {
				System.out.println("No time for kidding. Thank You for trying us. Have a great day!! ");
				b=false;
				break;
			}
		
			switch(choice) {
			
			case 1:
				//addcart();
				break;		
			case 2:
				break;
			case 3:
				DescriptionPage firstimpl = new DescriptionPage();
				firstimpl.showDescription();
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
		sc.close();
		
		
		
		
	}

}
