package banking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class verifyToTestFastWithdrawalWhenBalanceIsZeroHandlingException {

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

		this.myCheckingAccount.deposit(50);


		// try to make fast withdrawal
		// default is 50
		try {
			this.myCheckingAccount.fastWithdraw();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		// balance should be 0 , no balance left out
		assertEquals(0, this.myCheckingAccount.balance);
		
		
		// expecting exception when i try to make fast withdrawal because of 0 balance
		assertThrows(Exception.class, () -> {
			this.myCheckingAccount.fastWithdraw();
		});

	}

}
