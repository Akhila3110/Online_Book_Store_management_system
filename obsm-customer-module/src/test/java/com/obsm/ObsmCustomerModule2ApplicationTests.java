package com.obsm;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import com.obsm.customer.model.Customer;
import com.obsm.customer.repository.CustomerRepo;
import com.obsm.customer.service.ICustomerService;

@ContextConfiguration
@SpringJUnitConfig
class ObsmCustomerModule2ApplicationTests {
@Mock
CustomerRepo repo;
@MockBean
ICustomerService service;
	 @Test
     void testAddCustomer() {	
			Customer customer= new Customer();
			customer.setCustomerName("Akhila");
			customer.setCustomerEmail("akhil123@gmail.com");;
			customer.setCustomerPassword("Akhila31");
			customer.setPhoneNumber(9515189083L);
			customer.setAddress("H.No:9-76, Hyderabad,Telangana");
			customer.setCity("Hyderabad");
			customer.setZipCode("502278");
			customer.setCountry("India");
					
		Mockito.when(repo.save(customer)).thenReturn(customer);
		assertThat(repo.save(customer).equals(customer));
	}
	
	@Test
	void testDeleteCustomer()
	{
		service.deleteCustomer(71);
		verify(service,times(1)).deleteCustomer(71);
	}
	
	@Test
	void testGetCustomerById()
	{
		service.getCustomerById(71);
		verify(service,times(1)).getCustomerById(71);
	}
	
	@Test
	void testGetAllCustomer()
	{
		service.getAllCustomer();
		verify(service,times(1)).getAllCustomer();
	}
	@Test
	void testValidateCustomer()
	{
		repo.findByCustomerEmail("akhilakatkuri98@gmail.com");
		verify(repo,times(1)).findByCustomerEmail("akhilakatkuri98@gmail.com");
	}
	@Test
	void contextLoads() {
	}
}
