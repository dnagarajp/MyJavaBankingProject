package banking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class verifyToDepositingNegativeAmount {

	// declares objects for testing.

	protected Customer customer;
	protected BankAccount myCheckingAccount;

	@BeforeEach
	void setUp() throws Exception {
		// initialize the objects for testing
		this.customer = new Customer("Deep");
		this.myCheckingAccount = new BankAccount("checking", this.customer);
	}

	@Test
	void test() {
		
		// make deposit of negative amounT
		this.myCheckingAccount.deposit(-100);

		// balance should be same
		assertEquals(0, this.myCheckingAccount.balance);

	}

}
