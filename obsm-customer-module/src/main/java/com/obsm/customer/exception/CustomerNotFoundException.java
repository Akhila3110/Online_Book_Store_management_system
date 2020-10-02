package com.obsm.customer.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

/************************************************************************************************************************************* 
-Author                : Akhila Katkuri
-Description           : It is a CustomerNoutFoundException which occurs when the customer Id is not present in the database but 
                         we are trying to update or delete the customer
-Created/Modified Date : 22/09/2020
*************************************************************************************************************************************/

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomerNotFoundException extends RuntimeException{
	public CustomerNotFoundException(String error){
        super(error);

}
}
