package com.example.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "empAddress")
public class EmpAddress {

	public String street;
	public String city;
	public String country;
	public String zipCode;	
	
	public EmpAddress(String street, String city, String country, String zipCode) {
		super();
		this.street = street;
		this.city = city;
		this.country = country;
		this.zipCode = zipCode;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	
	
}
