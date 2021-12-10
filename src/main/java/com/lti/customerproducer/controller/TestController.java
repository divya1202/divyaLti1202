package com.lti.customerproducer.controller;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lti.customerproducer.dao.CustomerRepository;
import com.lti.customerproducer.exception.ResourceNotFoundException;
import com.lti.customerproducer.model.Customer;


@CrossOrigin(origins = "*")
@RequestMapping("/api")
@RestController
public class TestController {
		
	@Autowired
	CustomerRepository repository;
	
	
	@RequestMapping(value = "/customer", method = RequestMethod.POST)
	public Customer addCustomer(@RequestBody Customer customer) {

		return repository.save(customer);
	}
   
	
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public List<Customer>  getCustomerdetails() {		
		 List<Customer> customerList= repository.findAll();
		 return customerList;	
	}
	
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
	public Customer getCustomerdetailbyId(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {		
	 return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("customer id  not found "+ id));
	
	}
	
	
	
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
	public Map<String, Boolean> deleteCustomerById(@PathVariable(value = "id") Integer id) {
		
		 repository.deleteById(id);
		 Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
		 
		 
	}
   
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.PUT)
	public Customer updateEmployee(@PathVariable(value = "id") Integer Id,
		 @RequestBody Customer customerDetails) throws ResourceNotFoundException {
		
		Customer customer = repository.findById(Id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + Id));

		customer.setAge(customerDetails.getAge());
		customer.setAddress(customerDetails.getAddress());
		customer.setName(customerDetails.getName());
		customer.setAccType(customerDetails.getAccType());
		return repository.save(customer);
	}
	
	


}

