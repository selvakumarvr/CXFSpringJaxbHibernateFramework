package com.cxf.ws.api;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import com.cxf.web.dto.req.GetUserRequest;

import com.cxf.web.dto.resp.GetUserResponse;
/**
 * 
 * Title: PaymentWebserviceEndpoint.java 
 * 
 * Company: CSAA
 * @author Selva
 */
@WebService(targetNamespace = "http://services.cxf.com/ws")
public interface TestWebserviceEndpoint {

	
	@WebMethod(operationName = "saveUser")
	@RequestWrapper(targetNamespace = "http://services.cxf.com/ws")
	GetUserResponse saveUser(
	
			@WebParam(name = "getUserRequest") GetUserRequest getUserRequest);


}
