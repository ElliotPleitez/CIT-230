import java.util.ArrayList;
import java.util.Scanner;

/** This program creates an Account class with the following private data fields a String name, a int id, a double balance, a double annual interest rate, a date created and an Arraylist transaction. I has a no-arg constructor which sets the id, balance, and annual interest rate to zero. I has all the get and set methods for the fields and also added get methods to compute monthly interest rate, widthdraw, and deposit money using the Transaction class. */

class Account {
/** Data fields */
  private String name;
  private int id;
  private double balance, annualInterestRate;
  private java.util.Date dateCreated;
  java.util.ArrayList<Transaction> transactions;

/** Create an account with default values */

  Account() {
    this.id = 0;
    this.balance = 0;
    this.annualInterestRate = 0;
    this.dateCreated = new java.util.Date();
    this.transactions = new ArrayList<Transaction>();
  }

/** Create an account with specified id and balance */

  Account(int newID, double newBalance) {
    this.id = newID;
    this.balance = newBalance;
    this.dateCreated = new java.util.Date();
    this.transactions = new ArrayList<Transaction>();
  }

/** Create and account with specified name, id, balance, and annual interest rate */

  Account(String name, int newID, double newBalance) {
    this.name = name;
    this.id = newID;
    this.balance = newBalance;
    this.dateCreated = new java.util.Date();
    this.transactions = new ArrayList<Transaction>();
  }

/** Get account name */

  public String getName() {
    return this.name;
  }

/**  Set account name */

  public void setName(String newName) {
    this.name = newName;
  }

/** Get account ID */

  public int getID() {
    return this.id;
  }

/**  Set account ID */

  public void setID(int newID) {
    this.id = newID;
  }

/** Get account balance */

  public double getBalance() {
    return this.balance;
  }

/**  Set account balance */

  public void setBalance(double newBalance) {
    this.balance = newBalance;
  }

/** Get account annual interest rate */

  public double getAnnualInterestRate() {
    return this.annualInterestRate;
  }

/**  Set account annual interest rate */

  public void setAnnualInterestRate(double newAnnualInterestRate) {
    this.annualInterestRate = newAnnualInterestRate;
  }

/** Get account date account was created */

  public java.util.Date getDateCreated() {
    return this.dateCreated;
  }

/** Get monthly interest rate */

  public double  getMonthlyInterestRate() {
    return this.annualInterestRate / 12; // monthly interest rate = annual interest rate divide by 12
  }

/** Get monthly interest */

  public double  getMonthlyInterest() {
    return this.balance * this.getMonthlyInterestRate();
  }

/** Withdraw some money */

  public void makeWithdrawal() {
    java.util.Date date = new java.util.Date(); // Set date of withdrawal
    char type = 'W'; // Set type as W for withdrawal
    Scanner inputAmount = new Scanner(System.in); 
    System.out.println("Enter amount to withdraw i.e 1000 : "); // Prompt user for withdrawal amount
    double amount = inputAmount.nextDouble(); // Record amount of withdrawal
    balance = (this.getBalance() - amount); // set new balance after withdrawal.
    Scanner inputDesc = new Scanner(System.in);
    System.out.println("Enter a description: "); // Prompt user for a description
    String description = inputDesc.next(); // Record description
    // Create an instance of the Transaction
    Transaction withdrawal = new Transaction(date, type, amount, balance, description);
    this.transactions.add(withdrawal); // Save transaction to the list of transactions
  }

  public void makeDeposit() {
    java.util.Date date = new java.util.Date();
    char type = 'D';
    Scanner inputAmount = new Scanner(System.in);    
    System.out.println("Enter amount to deposit i.e 1000 : ");
    double amount = inputAmount.nextDouble();
    balance = (this.getBalance() + amount);
    Scanner inputDesc = new Scanner(System.in);    
    System.out.println("Enter a description: ");
    String description = inputDesc.next();
    Transaction deposit = new Transaction(date, type, amount, balance, description);
    this.transactions.add(deposit);
  }

/** Return a string representation of this object */
  
  public String toString() {
    return "Account name: " + this.getName() + " \nInterest rate: " + this.getAnnualInterestRate() +       "%" + " \nbalance: " + this.getBalance();
  }

}