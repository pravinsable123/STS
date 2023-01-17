package com.ether.ecommerce.display;

import java.util.Scanner;

import com.ether.ecommerce.product.ProductApple;
import com.ether.ecommerce.product.ProductBosch;
import com.ether.ecommerce.product.ProductCanon;
import com.ether.ecommerce.product.ProductCasio;
import com.ether.ecommerce.product.ProductDell;
import com.ether.ecommerce.product.ProductLg;
import com.ether.ecommerce.product.ProductMi;
import com.ether.ecommerce.product.ProductNikon;
import com.ether.ecommerce.product.ProductSamsung;
import com.ether.ecommerce.product.ProductVoltas;
import com.ether.ecommerce.user.Guest;

public class DescriptionPage extends Guest{
Scanner sc = new Scanner(System.in);
	
	public void showDescription() {
		DescriptionPage dp = new DescriptionPage();
		dp.showProductList();
		System.out.println("11. Exit App ");
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Select Product Number for More Details : ");
		
		int choice = sc.nextInt();
		boolean b = true;

			switch(choice) {
			
			case 1:
				ProductApple apple = new ProductApple();
				apple.getAppleiPhoneDesc();
				break;
				
			case 2:
				ProductBosch bosch = new ProductBosch();
				bosch.getBOSCHDishwasherDesc();
				break;
				
			case 3:
				ProductCanon canon = new ProductCanon();
				canon.getCanonPrinterDesc();
				break;
				
			case 4:
				ProductCasio casio = new ProductCasio();
				casio.getCasioWatchDesc();
				break;
				
			case 5:
				ProductDell dell = new ProductDell();
				dell.getDellInspironDesc();
				break;
				
			case 6:
				ProductLg lg = new ProductLg();
				lg.getLGRefrigeratorDesc();
				break;
				
			case 7:
				ProductMi mi = new ProductMi();
				mi.getMiTVDesc();
				break;
				
			case 8:
				ProductNikon nikon = new ProductNikon();
				nikon.getNikonDSLRDesc();
				break;
				
			case 9:
				ProductSamsung samsung = new ProductSamsung();
				samsung.getSamsungGalaxyDesc();
				break;
				
			case 10:
				ProductVoltas voltas = new ProductVoltas();
				voltas.getVoltasACDesc();
				break;
				
			case 11:
				System.out.println("Thank You for Shopping with us. Have a great Day!");
				b=false;
				break;
				
			default :
				System.out.println("Please make a valid choice :");
					
			}

	
		
		
	}
}
