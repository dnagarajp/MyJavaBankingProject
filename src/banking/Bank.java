package banking;

import java.util.Scanner;

/**
 * Represents a bank for managing customers and their bank accounts.
 * @author deepa
 *
 */
public class Bank {

	public static void main(String[] args) {
		
		//creates new instance of Bank class
		Bank bank = new Bank();
		
		//calls the run method in the bank class
		bank.run();
	}
	
	/**
	 * Runs the program by initializing and managing, bank accounts and customers.
	 */
	public void run()
	{
		System.out.println("Welcome to the Bank! what is your name? ");
		
		//creating a scanner to get input
		Scanner scanner = new Scanner(System.in);
		
		//read the string input/word, which is customer name
		String name=scanner.next();
		
		System.out.println("Hello" + name + "! we are creating checking and savings account for you ");
		
		//create customer with given name
		Customer customer = new Customer(name);
		
		System.out.println("Enter your address");
		
		//read the address with given address
		String address = scanner.next();
		
		//set the customer address
		customer.setAddress(address);
		
		//create a checking for customer
		BankAccount checkingAccount = new BankAccount("checking",customer);
		
		//create a savings for customer
		BankAccount savingsAccount = new BankAccount("savings",customer);
	
		// gets and print  the customer  info associated with name and address of a checking account
		
		System.out.println();
		System.out.println("Customer info: ");		
		System.out.println(checkingAccount.getCustomerInfo());
		System.out.println("CheckingAccount info: ");
		System.out.println(checkingAccount.getAccountInfo());
		
		
		System.out.println(savingsAccount.getCustomerInfo());
		System.out.println("SavingsAccount info: ");
		System.out.println(savingsAccount.getAccountInfo());
		
		
		//deposits
		
		// into checking account
	    System.out.println();
	    System.out.println("Amount to deposit into your checking acocunt?");
	    double amount = scanner.nextDouble(); // get the double input to store in amount
	    checkingAccount.deposit(amount); //deposit the amount in checking account
	
	    // into savings account
	    System.out.println();
	    System.out.println("Amount to deposit into your savings acocunt?");
	    amount = scanner.nextDouble(); // get the double input to store in amount
	    savingsAccount.deposit(amount); //deposit the amount in savings account
	    
	    
		System.out.println(checkingAccount.getAccountInfo());	
		System.out.println(savingsAccount.getAccountInfo());
		
		//withdraw
		
		// into checking account
	    System.out.println();
	    System.out.println("Amount to withdraw from  your checking acocunt?");
	    amount = scanner.nextDouble(); // get the double input to store in amount
	    try {
			checkingAccount.withdraw(amount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	    
	    
	    //withdraw the amount in savings account
	
	    // into savings account
	    System.out.println();
	    System.out.println("Amount to withdraw into your savings acocunt?");
	    amount = scanner.nextDouble(); // get the double input to store in amount
	    try {
			savingsAccount.withdraw(amount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	    
	    
	    //deposit the amount in savings account
	    
	    
		System.out.println(checkingAccount.getAccountInfo());	
		System.out.println(savingsAccount.getAccountInfo());		
		
		scanner.close();
		
	}
}
