package com.ilp.entity;

import java.util.ArrayList;

public class Customer {
	
	private String customerName;
	private String customerCode;
	private ArrayList<Account>account;
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public ArrayList<Account> getAccount() {
		return account;
	}

	public void setAccount(ArrayList<Account> account) {
		this.account = account;
	}

	public Customer( String customerCode,String customerName, ArrayList<Account> accountList) {
		
		this.customerName = customerName;
		this.customerCode = customerCode;
		this.account = accountList;
	}

	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", customerCode=" + customerCode + ", account=" + account
				+ "]";
	}
	

}
