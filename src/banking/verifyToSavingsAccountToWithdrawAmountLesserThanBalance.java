package banking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class verifyToSavingsAccountToWithdrawAmountLesserThanBalance {

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

		// try to make withdrawal of 80
		try {
			this.mySavingsAccount.withdraw(80);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// verify balance should be 20
		assertEquals(20, this.mySavingsAccount.balance);

	}

}
