package com.cxf.ws.payment.endpoint;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;

import com.cxf.ws.api.TestWebserviceEndpoint;
import com.cxf.web.dto.req.GetUserRequest;

import com.cxf.web.dto.resp.GetUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;



import com.spring.model.Person;
import com.spring.service.PersonManager;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

//@Endpoint
@Service(value="testSvcEndpoint")
@WebService(endpointInterface = "com.cxf.ws.api.TestWebserviceEndpoint", targetNamespace = "http://services.cxf.com/ws")
public class TestWebserviceImpl implements TestWebserviceEndpoint {
	  private static Logger logger = Logger.getLogger(TestWebserviceImpl.class);
	
	  @Resource(name="personManager")
	    private PersonManager personManager = null;
	  

	    public PersonManager getPersonManager() {
	        return personManager;
	    }

	    public void setPersonManager(PersonManager personManager) {
	        this.personManager = personManager;
	    }
	    
	    

	public GetUserResponse saveUser(
			GetUserRequest getUserRequest) {
		GetUserResponse getUserResponse = new GetUserResponse();
		try {

		
		
			System.out.println("Entered here1");
			
			System.out.println("Entered here2"+getUserRequest);
			
			System.out.println("Entered here3"+getUserRequest.getFirstName());
			System.out.println("Entered here4"+getUserRequest.getLastName());
			System.out.println("Entered here5"+getUserRequest.getName());
			
			
			   Person person1 = new Person(getUserRequest.getFirstName(), getUserRequest.getLastName(), getUserRequest.getName());
			   
			  
		        logger.debug("person1 = " + person1);
		        
		        List<Person> persons = new ArrayList<Person>();
		        persons.add(person1);
		        logger.debug("persons = " + persons);
		        
		        
		        // Insert
		        personManager.insertPersons(persons);
		        
		        System.out.println("Inserted ");
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return getUserResponse;

	}

	

}
