package banking;

/**
 * Represent a customer of a bank
 * @author deepa
 *
 */
public class Customer {
	
	//instance vars
	
	/**
	 * Name of customer
	 */
	String name;
	
	/**
	 * Address of a customer
	 */
	String address;
	
	//constructor
	/**
	 * Creates a customer with given name.
	 * @param name of a customer
	 */
	public Customer(String name) {
		//sets the instance var name to given name
		this.name = name;
	}
	
	//method
	/**
	 * Sets the address of customer to be given address
	 * @param address
	 */
	public void setAddress(String address)
	{
		this.address =address;
	}
	
	/**
	 * Returns the customer's name.
	 * @return name of the customer.
	 */
	
	public String getName() {
		return this.name;
	}
	
	
	/**
	 * Returns the address of the customer
	 * @return address of the customer
	 */
	public String getAddress() {
		return this.address;
	}
}
