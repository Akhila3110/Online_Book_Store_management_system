package com.obsm.customer.model;
import java.util.List;

public class CustomerList {

	private List<Customer> list;

	public CustomerList(List<Customer> list) {
		super();
		this.list = list;
		
	}



	public List<Customer> getList() {
		return list;
	}



	public void setList(List<Customer> list) {
		this.list = list;
	}



	@Override
	public String toString() {
		return "OrderList [list=" + list + "]";
	}

	}