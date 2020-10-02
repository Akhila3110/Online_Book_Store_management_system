package com.obsm.customer.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.obsm.customer.model.Customer;
import com.obsm.customer.service.ICustomerService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Customer")
public class CustomerController {
	
	@Autowired
	ICustomerService service;
	

	
	@PostMapping("/addCustomer")
	public Customer addCustomer(@RequestBody Customer customer){
		return customer=service.addCustomer(customer);
	}
	
	@DeleteMapping("/deleteCustomer/{customerId}")
	public void deleteCustomer(@PathVariable long customerId)  {
		 
		service.deleteCustomer(customerId);
		
	}
	@PutMapping("/updateCustomer/{customerId}")
	public ResponseEntity<Object> updatecustomer(@PathVariable("customerId") long id, @RequestBody Customer customer)
	{
		try {
		service.updateCustomer(id,customer);
		return new ResponseEntity<>("Customer Updated",HttpStatus.OK);}
		catch(Exception e) {
			return new ResponseEntity<>("Details Not Found",HttpStatus.NOT_FOUND); 
	}}
	

	@GetMapping("/id/{customerId}")
	public Customer getCustomerById(@PathVariable long customerId) {
		
		return service.getCustomerById(customerId);
		
	}
	

	@GetMapping("/all")
	public List<Customer> getAllCustomer(){
		return service.getAllCustomer();	
	}
	
	
	@GetMapping("/validate/{customerEmail}/{customerPassword}")
	public ResponseEntity<Boolean> validateCustomer(@PathVariable String customerEmail, @PathVariable String customerPassword) {
		boolean valid =  service.validateCustomer(customerEmail,customerPassword);
		if(valid) {
		return new ResponseEntity<Boolean>(valid, HttpStatus.ACCEPTED);
	}else
	{
		return new ResponseEntity<Boolean>(valid, HttpStatus.NOT_ACCEPTABLE);
	}
	}
	
}          	
	
	
	                             
	
	
	                         
	
	
	
	                             

