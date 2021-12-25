package banking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class verifyToDepositToCheckingAccountWithZeroAmount {

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
		// deposit 0 to checking account
		this.myCheckingAccount.deposit(0);

		// verify that the deposit has 0
		assertEquals(0, this.myCheckingAccount.balance);
	}

}
