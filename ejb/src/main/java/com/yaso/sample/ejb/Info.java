package com.yaso.sample.ejb;

import jakarta.ejb.Stateless;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;

@Stateless
@WebService
public class Info {
	
	@WebMethod
	public String get() {
		return "EJB";
	}
}
