package banking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class verifyToTestFastWithdrawalDoesNotThrowAnyExceptionByResettingFastWithDrawal {

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
		
		// deposit some value into checking account which is 100
		this.myCheckingAccount.deposit(100);
		
		// reset the fast cash amount
		this.myCheckingAccount.setsFastCashAmount(20);

		// assert that no exception throws when i make fast cash withdrawal
		assertDoesNotThrow(() -> {
			this.myCheckingAccount.fastWithdraw();
		});
		

		assertEquals(80, this.myCheckingAccount.balance);
	}

}
