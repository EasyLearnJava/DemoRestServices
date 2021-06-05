package com.example;

import java.util.ArrayList;

//https://www.journaldev.com/498/jersey-java-tutorial
//https://www.cwiki.us/display/JERSEYZH/Creating+a+Web+Application+that+can+be+deployed+on+Heroku
//mvn archetype:generate -DarchetypeArtifactId=jersey-heroku-webapp -DarchetypeGroupId=org.glassfish.jersey.archetypes -DinteractiveMode=false -DgroupId=com.example -DartifactId=simple-heroku-webapp -Dpackage=com.example -DarchetypeVersion=2.26

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.example.db.EmployeeDB;
import com.example.exception.EmpNotFoundException;
import com.example.model.EmpAddress;
import com.example.model.Employee;

@Path("/employee")
public class EmployeeService {

	@POST	
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response getEmp(Employee empRequest) throws EmpNotFoundException {
		/*Employee emp = empRequest;
		int empCount = EmployeeDB.allEmployees.size();
		empRequest.setId(empCount + 1);
		
		EmpResponse empResponse = new EmpResponse();
		if (empRequest.getValue().getId() == 1) {			
			return Response.ok(EmployeeDB.hashMapDB.get(1)).build();
		} else {
			throw new EmpNotFoundException("Wrong ID", empRequest.getValue().getId());
		}*/
		System.out.println("$$$$ : " + empRequest);
		return Response.ok().build();
	}
	
	@GET		
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response getEmployee() throws EmpNotFoundException {
		return Response.ok(EmployeeDB.allEmployees).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response getAnEmployee(@PathParam("id") Integer empId) throws EmpNotFoundException {
		
		EmpAddress empRaghuCurrent = new EmpAddress("123", "Dallas", "USA", "12345");
		EmpAddress empRaghuHome = new EmpAddress("393", "Vizag", "INDIA", "530012");
		ArrayList<EmpAddress> RaghuAddressList = new ArrayList();
		RaghuAddressList.add(empRaghuHome);
		RaghuAddressList.add(empRaghuCurrent);
		Employee e =new Employee(1, "Raghu", "raghu@gmail.com", RaghuAddressList);
		System.out.println("^^^ : " + EmployeeDB.hashMapDB.get(empId));
		return Response.ok(e).build();
	}
}
