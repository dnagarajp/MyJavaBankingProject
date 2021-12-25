package banking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class verifyToDepositToCheckingAccount {

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
		
		// make some deposit
		this.myCheckingAccount.deposit(100);

		// verify that 100 is deposited to checking account
		assertEquals(100, this.myCheckingAccount.balance);
	}

}
