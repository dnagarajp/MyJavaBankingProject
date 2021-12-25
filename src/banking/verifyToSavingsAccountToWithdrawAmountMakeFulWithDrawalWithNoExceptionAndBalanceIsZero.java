package banking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class verifyToSavingsAccountToWithdrawAmountMakeFulWithDrawalWithNoExceptionAndBalanceIsZero {

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
		
		// deposit some value into savings account which is 20
		this.mySavingsAccount.deposit(20);
		

		// try to make full withdrawal
		// should not throw any exception
		assertDoesNotThrow(() -> {
			this.mySavingsAccount.withdraw(20);
		});

		// verify balance is 0
		assertEquals(0, this.mySavingsAccount.balance);

	}

}
