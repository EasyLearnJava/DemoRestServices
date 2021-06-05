package com.example;

import java.io.IOException;

//Request paarameter types - https://www.baeldung.com/jersey-request-parameters
//https://www.java2novice.com/restful-web-services/http-basic-authentication/

import java.util.Date;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.commons.codec.binary.Base64;


@Path("/demo")
public class DemoGetExamples {
	
	@GET
    @Path("time")
    public String getServerTime() {
        System.out.println("RESTful Service 'MessageService' is running ==> ping");
        return new Date().toString();
    }
	
	@GET
	@Path("greeting")
    public Response getGreeting(@DefaultValue("Guest") @QueryParam("name") String name) {
        System.out.println("Greet User");
        StringBuilder builder = new StringBuilder();
        builder.append("Hello ").append(name).append(", Welcome to WebServices Tutorial");
        String output = builder.toString();
        return Response.status(200).entity(output).build();
    }
	
	@GET	
	@Path("message/{username}")
    public Response getUserGreeting(@PathParam("username") String name) {
        System.out.println("Greet User");
        StringBuilder builder = new StringBuilder();
        builder.append("Hello ").append(name).append(", Welcome to WebServices Tutorial");
        String output = builder.toString();
        return Response.status(200).entity(output).build();
    }
	
	@GET	
	@Path("salary")
    public Response getUserSalary(@HeaderParam("authorization") String authString) {
        System.out.println("Auth String : " + authString);
        
        if(null == authString) {
        	return Response.status(404).entity("{\"error\":\"Missing user authentication\"}").build();
        }
        
        if(!isUserAuthenticated(authString)){
        	return Response.status(401).entity("{\"error\":\"User not authenticated\"}").build();
        }
        
        return Response.status(200).entity("5000").build();
    }
	
	private boolean isUserAuthenticated(String authString){
        
        String decodedAuth = "";
        // Header is in the format "Basic 5tyc0uiDat4"
        // We need to extract data before decoding it back to original string
        String[] authParts = authString.split("\\s+");
        String c = authParts[1];
        // Decode the data back to original string
        byte[] bytes = null;
        
        	Base64 base64 = new Base64();
            bytes = base64.decode(c.getBytes());
        
        decodedAuth = new String(bytes);
        System.out.println("@@@@@@@@ : " + decodedAuth);
         
        /**
         * here you include your logic to validate user authentication.
         * it can be using ldap, or token exchange mechanism or your 
         * custom authentication mechanism.
         */
        // your validation code goes here....
         
        return true;
    }

}
