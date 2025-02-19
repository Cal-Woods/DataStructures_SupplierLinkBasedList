package Classes;

import java.util.InputMismatchException;

/**
* Stores details for individual suppliers and contains methods for manipulating attributes.
*/
public class Supplier {
    //Attributes
    private String supplierName;
    private String supplierAddress;
    private double amountOwed;
    private double creditLimit;

    //Constructors
    public Supplier() {
        this.supplierName = "John Doe";
        this.supplierAddress = "No address given";
        this.amountOwed = 0.00;
        this.creditLimit = 0.00;
    }

    /**
     * An argument constructor
     * @param name The String name of the supplier
     * @param address The String address of the supplier
     * @param amountOwed The double amountOwed to the supplier
     * @param creditLimit The double creditLimit that represents how much can be owed to a supplier
     */
    public Supplier(String name, String address, double amountOwed, double creditLimit) {
        setName(name);
        setAddress(address);
        setAmountOwed(amountOwed);
        setCreditLimit(creditLimit);
    }

    //Getter methods
    public String getName() {
        return supplierName;
    }
    public String getAddress() {
        return supplierAddress;
    }
    public double getAmountOwed() {
        return amountOwed;
    }
    public double getCreditLimit() {
        return creditLimit;
    }

    //Setter/mutator methods
    public boolean setName(String name) {
        //Validate arguments
        //Check if name method argument is blank or null
        if(name == null) {
            throw new IllegalArgumentException("Given name String must NOT be null.");
        }
        if(name.isBlank()) {
            return false;
        }

        //Set supplierName to given name
        this.supplierName = name;
        return true;
    }
    public boolean setAddress(String address) {
        //Validate arguments
        if(address == null) {
            throw new IllegalArgumentException("Given address must NOT be null");
        }
        if(address.isBlank()) {
            return false;
        }

        //Set address to argument
        this.supplierAddress = address;
        return true;
    }
    public boolean setAmountOwed(double amount) {
        //Validate arguments
        if(Double.isNaN(amount)) {
            throw new InputMismatchException("Given amount must be a valid decimal number.");
        }

        //Set amountOwed to amount argument
        this.amountOwed = amount;
        return true;
    }
    public boolean setCreditLimit(double limit) {
        //Validate arguments
        if(Double.isNaN(limit)) {
            throw new InputMismatchException("Given limit must be a valid number.");
        }
        if(limit < 0.00) {
            throw new IllegalArgumentException("Given limit must NOT be a negative value.");
        }

        //Set creditLimit to limit argument
        this.creditLimit = limit;
        return true;
    }

    //Mutator methods
    /**
     * Increases the amount owed to this Supplier object, by specified amount.
     * @param amount The specified increase amount
     * @return A boolean indicating success of operation
     * 
     * @throws IllegalArgumentException If given amount is not a number
    **/
    public boolean increaseAmountOwed(double amount) {
        //Validate arguments
        if(Double.isNaN(amount)) {
            throw new IllegalArgumentException("Given amount must be a valid decimal number.");
        }
        //Ensure given amount is not a negative value
        if(amount < 0.00) {
            return false;
        }

        //Increase amountOwed by amount argument
        this.amountOwed += amount;
        return true;
    }

    /**
     * Decreases amount owed to this Supplier object, by the amount specified.
     * @param amount The amount, by which the amount owed will be decreased
     * @return A boolean indicating operation success
     * 
     * @throws IllegalArgumentException If specified amount is not a number
     **/
    public boolean decreaseAmountOwed(double amount) {
        //Validate arguments
        if(Double.isNaN(amount)) {
            throw new IllegalArgumentException("Given amount must be a valid decimal number.");
        }
        //Ensure given amount is not a negative value
        if(amount < 0.00) {
            return false;
        }

        //Increase amountOwed by amount argument
        amountOwed -= amount;
        return true;
    }
    
    //Override toString()
    @Override
    public String toString() {
        return "Name: "+supplierName+"\nAddress: "+supplierAddress+"\nOwed amount(Euro): "+amountOwed+"\ncredit limit: "+creditLimit+"\n";
    }
}