package com.example.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.model.EmpAddress;
import com.example.model.Employee;

public class EmployeeDB {
	
	public static Map<Integer, Employee> empHashMapDB = new HashMap<Integer, Employee>();
	public static Map<Integer, Employee> hashMapDB = new HashMap<Integer, Employee>();
	public static List<Object> allEmployees = new ArrayList<Object>();
	
	static {
		EmpAddress empRaghuCurrent = new EmpAddress("123", "Dallas", "USA", "12345");
		EmpAddress empRaghuHome = new EmpAddress("393", "Vizag", "INDIA", "530012");
		ArrayList<EmpAddress> RaghuAddressList = new ArrayList();
		RaghuAddressList.add(empRaghuHome);
		RaghuAddressList.add(empRaghuCurrent);
		
		EmpAddress empRamyaCurrent = new EmpAddress("321", "Irving", "USA", "88776");
		ArrayList<EmpAddress> RamyaAddressList = new ArrayList();
		RamyaAddressList.add(empRamyaCurrent);
		
		ArrayList<EmpAddress> RiyaAddressList = new ArrayList();
		
		empHashMapDB.put(11, new Employee(1, "Raghu", "raghu@gmail.com"));
		empHashMapDB.put(12, new Employee(2, "Ramya", "ramya@yahoo.com"));
		empHashMapDB.put(13, new Employee(3, "Riya", "ramya@outlook.com"));
		
		hashMapDB.put(1, new Employee(1, "Raghu", "raghu@gmail.com", RaghuAddressList));
		//hashMapDB.put(2, new Employee(2, "Ramya", "ramya@yahoo.com", RamyaAddressList));
		//hashMapDB.put(3, new Employee(3, "Riya", "ramya@outlook.com", RiyaAddressList));
		
		allEmployees = hashMapDB.values().stream()
			    .collect(Collectors.toList());
	}

}
