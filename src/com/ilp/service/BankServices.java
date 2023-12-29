package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.CurrentAccount;
import com.ilp.entity.Customer;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsMaxAccount;
import com.ilp.entity.Service;

public class BankServices {

	private static Object account;



	public static ArrayList<Service> createServices(ArrayList<Service> serviceList) {
		
		
		Scanner scanner=new Scanner(System.in);
		char choice;
		do {
		System.out.println("Enter Service Code:");
		String serviceCode = scanner.nextLine();
		System.out.println("Enter Service Name:");
		String serviceName = scanner.nextLine();
		System.out.println("Enter service rate:");
		double serviceRate = scanner.nextDouble();
		scanner.nextLine();
		Service service = new Service(serviceCode,serviceName,serviceRate);
		serviceList.add(service);
		
		System.out.println("do u want to continue (y/n)");
		choice=scanner.next().charAt(0);
		scanner.nextLine();
	}while(choice=='y');
		return serviceList;
	}

	
	
	//create product
	public static ArrayList<Product> createProduct(ArrayList<Product> productList, ArrayList<Service> serviceList) {
		// TODO Auto-generated method stub
		
		ArrayList<Service> productServiceList = new ArrayList<Service>();
		//enter the product code and product name
		//enter the service you want
		//Cash Deposit
		Scanner scanner=new Scanner(System.in);
		
		char productchoice;
		do {
		System.out.println("Enter product Code:");
		String productCode = scanner.nextLine();
		System.out.println("Enter product Name:");
		String productName = scanner.nextLine();
		char choice;
		do {
		System.out.println("Enter service you want to add");
		String serviceChoice= scanner.nextLine();
		for(Service service:serviceList)
		{
			if(service.getServiceName().equalsIgnoreCase(serviceChoice))
			{
				productServiceList.add(service);
			}
			
		}
		
		
		if(productName.equalsIgnoreCase("SavingsMaxAccount") ){
			SavingsMaxAccount product = new SavingsMaxAccount(productCode, productName, productServiceList);
	         productList.add(product);}
//		Product product = new Product(,productServiceList);
//		productList.add(product);
		
		else if(productName.equalsIgnoreCase("CurrentAccount") ){
			CurrentAccount product = new CurrentAccount(productCode, productName, productServiceList);
	         productList.add(product);}
		
		else if(productName.equalsIgnoreCase("LoanAccount")) {
			LoanAccount product = new LoanAccount(productCode, productName, productServiceList);
	         productList.add(product);}
		
		
		System.out.println("do you want to add more services(y/n)");
		 choice=scanner.next().charAt(0);
		scanner.nextLine();
		}while(choice=='y');
		
		
		
		System.out.println("do you want to add more product(y/n)");
		 productchoice=scanner.next().charAt(0);
		scanner.nextLine();
		
		}while(productchoice=='y');
		return productList;
 

		
	}///create customer

	public static Customer createCustomer(Customer customer, ArrayList<Product> productList) {
		Product customerProduct = null;
		Customer customerCreated = null;
		
		if(customer == null)
		{
			
			ArrayList<Account> accountList = new ArrayList<Account>();
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter customer Code:");
			String customerCode = scanner.nextLine();
			System.out.println("Enter customer Name:");
			String customerName = scanner.nextLine();
			//customer code name
			
			//enter the productname;
			char choice;
			do {
				
				for(Product product:productList)
				{
					System.out.println(product.getProductName());
				}
				
			System.out.println("Enter required product name:");
			String customerproductchoice = scanner.nextLine();
			
			for(Product product:productList)
			{
				if(product.getProductName().equalsIgnoreCase(customerproductchoice));
				{
					customerProduct = product;
					
				}
			}

			System.out.println("Enter account no:");
			String accountNo = scanner.nextLine();
			System.out.println("Enter account type:");
			String accountType = scanner.nextLine();
			System.out.println("Enter account balance:");
			double balance = scanner.nextDouble();
			
			
			Account account = new Account(accountNo,accountType,balance,customerProduct) ;
			accountList = new ArrayList<Account>();
			accountList.add(account);
			
			
		
			System.out.println("Do you want to add more accounts? (y/n)");
	        choice = scanner.next().charAt(0);
	        scanner.nextLine(); 

	    } while (choice == 'y');
			
			 customerCreated = new Customer(customerCode,customerName, accountList);
			 
//			 System.out.println(customerCreated);
			 System.out.println("Customer Code : "+customerCreated.getCustomerCode());
			 System.out.println("Customer Name : "+customerCreated.getCustomerName());
			 
//			 System.out.println("Customer Name : "+customerCreated.getCustomerName());
			
			for(Account account : customerCreated.getAccount()) {
				System.out.println("Account Number : "+account.getAccountNo());
				System.out.println("Account Type : "+account.getAccountType());
				System.out.println("Account Balance : "+account.getBalance());
		}
		} 
		
	else {
		System.out.println("Customer Already Exists");
	}
		return customerCreated;}

	

///MANAGE ACCOUNT


public static void manageAccount(Customer customer) {
	// TODO Auto-generated method stub

	Scanner scanner =new Scanner(System.in);
	System.out.println("Enter customer id:");
	String customerId= scanner.nextLine();
	System.out.println("customerId="+customerId);
	System.out.println("customercode="+customer.getCustomerCode());
	
	if(customer.getCustomerCode().equals(customerId)) {
		System.out.println(customer.getCustomerName()+"has the following accounts");
		for(Account account1:customer.getAccount()) {
			System.out.println(account1.getProduct().getProductName());
		}
	}
	System.out.println("enter your choice");
//	System.out.println("1.Deposit  2.withdraw   2.display balan");
	 Account selectedAccount=null;
	String choice=scanner.nextLine();
	for(Account account1:customer.getAccount()) {
		if(account1.getProduct().getProductName().equalsIgnoreCase(choice))
			selectedAccount=account1;
		
	}System.out.println(selectedAccount);
	char continueChoice='n';
	do {
		System.out.println("enter your choice");
		System.out.println("1.Deposit  2.withdraw   2.display balance");
		int choice1=scanner.nextInt();
	switch(choice1) {
	case 1: selectedAccount.setBalance( deposit(selectedAccount));
	System.out.println(selectedAccount.getBalance());
	break;
	case 2: selectedAccount.setBalance(withdraw(selectedAccount));
	System.out.println(selectedAccount.getBalance());
	
	break;
	case 3: displayBalance(selectedAccount);
//	
	}System.out.println("do you want to go to main menu)");
	 char userChoice=scanner.next().charAt(0);
	scanner.nextLine();
	
	}while(continueChoice=='y');
	}


///DISPLAY BALANCE

private static void displayBalance(Account selectedAccount ) {
	// TODO Auto-generated method stub
	System.out.println("The accounts are"+selectedAccount.getBalance());
	
}

///WITHDRAW

private static double withdraw(Account selectedAccount) {
	// TODO Auto-generated method stub
	Scanner scanner=new Scanner(System.in);
	System.out.println("enter the amount to withdraw");
	int amount=scanner.nextInt();
	double updatedBalance= selectedAccount.getBalance()-amount;
	return updatedBalance;
}


///DEPOSIT
private static double deposit(Account selectedAccount) {
	// TODO Auto-generated method stub
	Scanner scanner=new Scanner(System.in);
	System.out.println("enter the amount to deposit");
	int amount=scanner.nextInt();
	double updatedBalance= selectedAccount.getBalance()+amount;
	return updatedBalance;
	
}



public static void displayCustomer(Customer customer, ArrayList<Account> accountList) {
	// TODO Auto-generated method stub
	
}}









