package banking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class verifyToTestFastWithdrawalResettingFastWithdrawalToNegativeAmountToBeIgnored {

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

		this.myCheckingAccount.deposit(100);

		// set fast cash amount to negative values
		// should be ignored.

		// should still ignored
		this.myCheckingAccount.setsFastCashAmount(-50);

		// try to make fast withdrawal
		// default is 50
		try {
			this.myCheckingAccount.fastWithdraw();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(50, this.myCheckingAccount.balance);

	}

}
