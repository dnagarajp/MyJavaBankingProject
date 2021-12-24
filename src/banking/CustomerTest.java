package banking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {

	Customer customer;
	
	@BeforeEach
	void setUp() throws Exception {
		
		//initialize customer here
		this.customer= new Customer("Deepa");
	}

	@Test
	void testSetAddress() {
		//confirms the initialize value of address is null
		assertNull(this.customer.getAddress());
		
		//sets address of customer
		this.customer.setAddress("India");
		
		//check the address was set correctly
		assertEquals("India",this.customer.getAddress());
		
		//resets address of customer
		this.customer.setAddress("Pak");
				
		//check the address was resets correctly
		assertEquals("Pak",this.customer.getAddress());
	}
	

}
