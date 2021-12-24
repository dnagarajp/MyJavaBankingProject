package banking;
/**
 * Represents a checking/savings bank account of a customer
 * @author deepa
 *
 */
public class BankAccount {

	
	// instance variables
	
	/**
	 * Type of account (checking/savings)
	 */
	String accountType;
	
	/**
	 * Balance for bank account.
	 */
	double balance;
	
	
	/**
	 * Customer for this account
	 */
	Customer customer;
	
	/**
	 * Fixed Amount for quick withdrawals
	 */
	double fastCashAmount;
	
	/**
	 * Creates a bank account of given Type for given customer
	 * @param accountType for the bank 
	 * @param customer for the bank
	 */
	public BankAccount(String accountType,Customer customer) {
		this.accountType=accountType;
		this.customer=customer;
		
		//set default value for fast cash withdrawal
		this.fastCashAmount = 50;
	}
	
	//methods
	/** 
	 * Deposits the given amount and greater than zero
	 * @param amount to add the balance
	 */
	public void deposit(double amount) {
		if(amount>0) {
		this.balance +=amount;
		}
	}
	
	/** 
	 * Withdraw the given amount from balance
	 * @param amount to  withdraw
	 * @throws Exception if given amount is larger than available balance
	 */
	public void withdraw(double amount) throws Exception {
		if(amount>this.balance) {
			throw new Exception("Amount is greater than available balance");
		}
		this.balance -=amount;
	}
	
	/**
	 * withdraw the fast cash amount if the amount is greater than available balance
	 * @throws Exception
	 */
	public void fastWithdraw() throws Exception {
		//withdraw given fast cash amount
		this.withdraw(fastCashAmount);
	}
	
	
	/**
	 * Sets the fast cash amount, if greater than 0
	 * @param amount
	 */
	public void setsFastCashAmount(double amount) {
		if(amount > 0) {
		this.fastCashAmount= amount;
		}
	}
	
	
	
	
	/**
	 * Return the account type and bank for this bank account
	 * @return string with all info
	 */
	public String getAccountInfo() {
		return this.accountType + ": " + this.balance;
	}
	
	
	/**
	 * Returns the customer name and address for this bank accounr 
	 * @return string with all info
	 */
	public String getCustomerInfo() {
		return this.customer.getName() + " from " + this.customer.getAddress();
	}
}
