package banking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class verifyToTestFastWithdrawalDoFastWithdrawalUntilBalanceIsZero {

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

		// fastWithDrawa of default 50
		try {
			this.myCheckingAccount.fastWithdraw();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// should still withdraw 50 when the balance is still available as 50
		// the balance should be 0
		try {
			this.myCheckingAccount.fastWithdraw();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// balance should be 0 after fast withdrawal twice
		assertEquals(0, this.myCheckingAccount.balance);
	}

}
