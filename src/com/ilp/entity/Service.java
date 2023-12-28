package com.ilp.entity;

public class Service {
	
	private String serviceName;
	private String serviceCode;
	private double rate;
	
	
	public Service(String serviceCode,String serviceName, double rate) {
		this.serviceName = serviceName;
		this.serviceCode = serviceCode;
		this.rate = rate;
	}


	public String getServiceName() {
		return serviceName;
	}


	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}


	public String getServiceCode() {
		return serviceCode;
	}


	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}


	public double getRate() {
		return rate;
	}


	public void setRate(double rate) {
		this.rate = rate;
	}


	@Override
	public String toString() {
		return "Service [serviceName=" + serviceName + ", serviceCode=" + serviceCode + ", rate=" + rate + "]";
	}
	
	
	

}
