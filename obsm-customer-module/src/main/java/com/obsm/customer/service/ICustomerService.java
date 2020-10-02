package com.obsm.customer.service;


import java.util.List;
import com.obsm.customer.model.Customer;

/*************************************************************************************************************************************
-Author                : Akhila Katkuri
-Created/Modified Date : 22/09/2020
-Description           : ICustomerService is the interface for Customer Management System that contains the method Declarations
                         Which are implemented in 
**************************************************************************************************************************************/

public interface ICustomerService {	
		
	public Customer  addCustomer(Customer customer) ;
        
    public void deleteCustomer(long customerId) ;
		
    public Customer updateCustomer(long customerId, Customer customer);
    
    public Customer getCustomerById(long customerid);
		
	public List<Customer> getAllCustomer();

	boolean validateCustomer(String customerEmail, String customerPassword);
		
	                     
	 
	 
	 
	 
	 
	 
	 
	 
	 
	                                     


	
    
		
		


	}


