package com.ilp.entity;

import java.util.ArrayList;

public abstract class  Product {
	private String productName;
	private String productCode;
	private ArrayList<Service>service;
	
	
	public Product(String productCode,String productName, ArrayList<Service> service) {
	
		this.productName = productName;
		this.productCode = productCode;
		this.service = service;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductCode() {
		return productCode;
	}


	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}


	public ArrayList<Service> getService() {
		return service;
	}


	public void setService(ArrayList<Service> service) {
		this.service = service;
	}


	@Override
	public String toString() {
		return "Product [productName=" + productName + ", productCode=" + productCode + ", service=" + service + "]";
	}
	
	

}
