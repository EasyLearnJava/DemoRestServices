package com.example.model;

import java.util.ArrayList;

import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")
@JsonbPropertyOrder({ "id", "name", "email", "address" })
public class Employee {
	private int id;
	private String name;
	private String email;
	private ArrayList<EmpAddress> address;	

	public Employee(int id, String name, String email, ArrayList<EmpAddress> address) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
	}
	
	public Employee(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<EmpAddress> getAddress() {
		return address;
	}

	public void setAddress(ArrayList<EmpAddress> address) {
		this.address = address;
	}
	
}