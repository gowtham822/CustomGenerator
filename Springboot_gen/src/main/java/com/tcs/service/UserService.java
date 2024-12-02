package com.tcs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.customer.CustomRepo;
import com.tcs.customer.Customer;

@Service
public class UserService {
	
	@Autowired
	private CustomRepo customRepo ;
	
	public void dataIns()
	{
		Customer c = new Customer();
		
		c.setName("gowtham");
		c.setState("Andhra Pradesh");
		
		customRepo.save(c);
	}

}
