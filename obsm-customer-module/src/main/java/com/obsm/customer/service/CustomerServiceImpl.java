package com.obsm.customer.service;


import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.obsm.customer.exception.CustomerExists;
import com.obsm.customer.exception.CustomerNotFoundException;
import com.obsm.customer.model.Customer;
import com.obsm.customer.repository.CustomerRepo;

/************************************************************************************************************************************
-Author                : Akhila Katkuri
-Created/Modified Date : 22/09/2020
-Description           : CustomerServiceImpl is the implementation for Customer Management System
*************************************************************************************************************************************/

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {
	


	@Autowired
	CustomerRepo repo;
	
	/********************************************************************************************************************************
	 -FunctionName          : addCustomer
	 -Description           : To Add the Customer Details
	 -Input Parameters      : Customer customer
	 -Return Type           : Customer
	 -Throws				: CustomerExists
	 -Author				: Akhila Katkuri
	 -Creation Date			: 22/09/2020
	********************************************************************************************************************************/
	
	@Override
	public Customer addCustomer(Customer customer) {
		
		if(customer!=null) {
			if(repo.existsById(customer.getCustomerId())) {
				throw new CustomerExists("Customer ID already exists !");
			}
			else{
				repo.save(customer);
			}
		}
		return customer;
		
	}
	
	
	/******************************************************************************************************************************
	 -FunctionName          : deleteCustomer
	 -Description           : To Delete the Customer
	 -Input Parameters      : long customerId
	 -Return Type           :     -
	 -Throws				: CustomerNotFoundException
	 -Author				: Akhila Katkuri
	 -Creation Date			: 22/09/2020
	******************************************************************************************************************************/

	
	@Override
	public void deleteCustomer(long customerId) {
		if(repo.existsById(customerId)) {
		repo.deleteById(customerId);
		}
		else {
			throw new CustomerNotFoundException("Customer Id does not exist !");
		}
	
	}
	
	
	/*********************************************************************************************************************************
	 -FunctionName          : updateCustomer
	 -Description           : To Update the Customer Details
	 -Input Parameters      : Customer customer
	 -Return Type           : Customer
	 -Throws				: CustomerNotFoundException
	 -Author				: Akhila Katkuri
	 -Creation Date			: 22/09/2020
	*********************************************************************************************************************************/

	@Override
	public Customer updateCustomer(long customerId,Customer customer) {
		
		Customer updatecustomer = repo.getOne(customerId);
		if( !(repo.existsById(customerId)))
		{ 
			throw new CustomerNotFoundException("customer not found");
			}
		    updatecustomer.setCustomerName(customer.getCustomerName());
		    updatecustomer.setCustomerEmail(customer.getCustomerEmail());
			updatecustomer.setAddress(customer.getAddress());
			updatecustomer.setPhoneNumber(customer.getPhoneNumber());
			repo.save(updatecustomer);
		
		return customer;
	}


	
	/********************************************************************************************************************************
	 -FunctionName          : getCustomerById
	 -Description           : To get the Customer Details by using particular Id
	 -Input Parameters      : long customerId
	 -Return Type           : Customer
	 -Throws				: CustomerNotFoundException
	 -Author				: Akhila Katkuri
	 -Creation Date			: 22/09/2020
	*********************************************************************************************************************************/

	@Override
	public Customer getCustomerById(long customerId) {
		if(!(repo.existsById(customerId))) {
			throw new CustomerNotFoundException("Customer Id does not exist !");
		}
		else {
		return repo.getOne(customerId);
	}
	}
	
	/**********************************************************************************************************************************
	 -FunctionName          : getAllCustomer
	 -Description           : To get the List of Customer Details
	 -Input Parameters      :      -
	 -Return Type           : List<Customer>
	 -Throws				: CustomerNotFoundException
	 -Author				: Akhila Katkuri
	 -Creation Date			: 22/09/2020
	**********************************************************************************************************************************/
	

	@Override
	public List<Customer> getAllCustomer() 
	{
     List<Customer> p = repo.findAll();
		
		if(p.isEmpty()) {
			throw new NullPointerException("The List is Empty !!");
		}
		else {
		
		return repo.findAll();
		}
	}
	
	/*********************************************************************************************************************************
	 -FunctionName          : ValidateCustomer
	 -Description           : To validate the customer Email and password
	 -Input Parameters      :  String customerEmail, String customerPassword
	 -Return Type           : boolean
	 -Author				: Akhila Katkuri
	 -Creation Date			: 22/09/2020
	**********************************************************************************************************************************/
	
	@Override
	public boolean validateCustomer(String customerEmail, String customerPassword) {
		try {

		boolean valid=false;
		Customer customer=repo.findByCustomerEmail(customerEmail);
		if(customer.getCustomerPassword().contentEquals(customerPassword)) {
			valid=true;
		}
		return valid;
		}catch(Exception e)
		{
			System.out.println("Invalid user Id");
			return false;
		}
	}
	 
}	          
                                     
	
	
	
	
	                                          

	
	


		
		




