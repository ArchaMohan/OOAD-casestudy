package com.ilp.utility;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.Service;
import com.ilp.service.BankServices;

public class BankUtility {

	public static void main(String[] args) {
		
		mainMenu();
		
		

	}

	private static void mainMenu() {
		
		int choice;
		ArrayList<Service> serviceList = new ArrayList<Service>();
		ArrayList<Product> productList = new ArrayList<Product>();
		ArrayList<Product> productServiceList = new ArrayList<Product>();
		ArrayList<Account> accountList = new ArrayList<Account>();
		String customerProduct=null;
		Customer customer = null;
		Scanner scanner = new Scanner(System.in);
		
		do {
		System.out.println("**********WELCOME TO BANK****");
		System.out.println("1.Create Service,2.create product,3.create customer,4.manage account,5.Display customer");
		System.out.println("Enter you choice :");
		choice = scanner.nextInt();
		switch(choice)
		{
		case 1:serviceList  = BankServices.createServices(serviceList);
				System.out.println(serviceList);
				break;
				
		case 2:productList = BankServices.createProduct(productList,serviceList);
		System.out.println(productList);
//		System.out.println(productServiceList);
		break;
		
		case 3:customer = BankServices.createCustomer(customer,productList);
		System.out.println(accountList);
		break;
		
		case 4:BankServices.manageAccount(customer,productList,accountList);

		
		
		
		}System.out.println("do you want to go to main menu)");
		 choice=scanner.next().charAt(0);
		scanner.nextLine();
		
		}while(choice=='y');
		
		
	}

}
