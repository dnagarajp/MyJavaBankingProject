package banking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankAccountTest {

	//declares objects for testing.
	
	Customer customer;
	BankAccount myCheckingAccount;
	BankAccount mySavingsAccount;
	@BeforeEach
	void setUp() throws Exception {
		
		//initialize the objects for testing
		this.customer = new Customer("Deep");
		this.myCheckingAccount = new BankAccount("checking",this.customer);
		this.mySavingsAccount = new BankAccount("savings",this.customer);
	}

	@Test
	void testDeposit() {
		//make some deposit
		this.myCheckingAccount.deposit(100);
		
		//verify that 100 is deposited to checking account
		assertEquals(100,this.myCheckingAccount.balance);
		
		//make deposit of negative amoun
		this.myCheckingAccount.deposit(-100);
		
		//balance should be same
		assertEquals(100,this.myCheckingAccount.balance);
		
		//deposit 0 to checking account
		this.myCheckingAccount.deposit(0);
		
		//verify that the deposit has 100
		assertEquals(100,this.myCheckingAccount.balance);
	}

	@Test
	void testWithdraw() {
		
		//deposit some value into savings account which is 100
		this.mySavingsAccount.deposit(100);
		
		//assert the savings account
		assertEquals(100,this.mySavingsAccount.balance);
		
		//try to make withdrawal of 80
		try {
			this.mySavingsAccount.withdraw(80);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// verify balance should be 20
		assertEquals(20,this.mySavingsAccount.balance);
		
		//try to withdraw some amount than available balance
		//expect an exception
		assertThrows(Exception.class, () ->{
			this.mySavingsAccount.withdraw(21);
		});
		
		//balance still should be the same
		assertEquals(20,this.mySavingsAccount.balance);
		
		try {
			this.mySavingsAccount.withdraw(24);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//balance still should be the same
		assertEquals(20,this.mySavingsAccount.balance);
		
		//try to make full withdrawal
        // should not throw any exception	
		assertDoesNotThrow(()->{
			this.mySavingsAccount.withdraw(20);
		});
		
		//verify balance is 0
		assertEquals(0,this.mySavingsAccount.balance);
		
	}

	@Test
	void testFastWithdraw() {
	
		this.myCheckingAccount.deposit(100);
		//try to make fast withdrawal
		//default is 50 
		try {
			this.myCheckingAccount.fastWithdraw();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//balance should be 50
		assertEquals(50,this.myCheckingAccount.balance);
		
		
		//reset the fast cash amount
		this.myCheckingAccount.setsFastCashAmount(20);
		
		//assert that no exception throws when i make fast cash withdrawal
		assertDoesNotThrow(() ->{
			this.myCheckingAccount.fastWithdraw();
		});

		assertEquals(30,this.myCheckingAccount.balance);
		
	    //set fast cash amount to negative values
		//should be ignored.
		
		//should still ignored 
		this.myCheckingAccount.setsFastCashAmount(-50);
		
		
		//should still withdraw 20 because of fast withdrawal and the balance is 10
		try {
			this.myCheckingAccount.fastWithdraw();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//balance should be 10 after fast withdrawal
		assertEquals(10,this.myCheckingAccount.balance);
		
		
		//reset the fast cash amount
		this.myCheckingAccount.setsFastCashAmount(10);
		
		//should still withdraw 10 when the fast withdrawal was set to 10
		// the balance should be 0
		try {
			this.myCheckingAccount.fastWithdraw();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//balance should be 0 after fast withdrawal
		assertEquals(0,this.myCheckingAccount.balance);
		
		
		//expecting exception when i try to make fast withdrawal because of 0 balance
		assertThrows(Exception.class, () -> {
			this.myCheckingAccount.fastWithdraw();
		});
		
	}

}
