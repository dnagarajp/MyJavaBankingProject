package banking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class verifyToSavingsAccountToWithdrawAmountGreaterThanBalance {

	protected Customer customer;
	protected BankAccount mySavingsAccount;

	@BeforeEach
	void setUp() throws Exception {

		// initialize the objects for testing
		this.customer = new Customer("Deep");
		this.mySavingsAccount = new BankAccount("savings", this.customer);
	}

	@Test
	void test() {

		// deposit some value into savings account which is 100
		this.mySavingsAccount.deposit(100);

		// try to make withdrawal of 101
		try {
			this.mySavingsAccount.withdraw(101);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// verify balance should be 100
		assertEquals(100, this.mySavingsAccount.balance);

	}

}
