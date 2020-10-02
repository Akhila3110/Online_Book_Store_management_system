
package com.obsm.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.obsm.customer.model.Customer;


/*************************************************************************************************************************************
-Author                : Akhila Katkuri
-Description           : CustomerRepository is the interface for Customer Management System Which contains JPA repository
-Created/Modified Date : 22/09/2020
*************************************************************************************************************************************/

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
	@Query("SELECT T FROM Customer T WHERE  T.customerEmail=:customerEmail")
    public Customer findByCustomerEmail(String customerEmail);
}
