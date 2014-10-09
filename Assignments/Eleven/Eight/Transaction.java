package Eleven.Eight;

class Transaction {
/** Data fields */

  private java.util.Date date;
  private char type;
  private double amount;
  private double balance;
  private String description;

/**  Construct a transaction with specified fields */
  Transaction(java.util.Date date, char type, double amount, double balance, String description) {
	  this.date = date;
	  this.type = type;
	  this.amount = amount;
	  this.balance = balance;
	  this.description = description;
  }

/**  Return date of transaction */
  public java.util.Date getDate() {
    return this.date;
  }

/**  Return type of transaction */
  public char getType() {
    return this.type;    
  }

/**  Set type of transaction */
  public void setType(char newType) {
    this.type = newType;    
  }

/**  Return amount of transaction */
  public double getAmount() {
    return this.amount;    
  }

/**  Set amount of transaction */
  public void setAmount(double newAmt) {
    this.amount = newAmt;    
  }

/**  Return balance after transaction */
  public double getBalance() {
    return this.balance;    
  }

/**  Set balance after transaction */
  public void setBalance(double newBal) {
     this.balance = newBal;    
  }


/**  Return description of transaction */
  public String getDescription() {
    return this.description;    
  }

/**  Set description of transaction */
  public void setDescription(String newDesc) {
    this.description = newDesc;    
  }

/** Return a string representation of this object */
  public String toString() {
    return "Date " + this.getDate() + ", Type " + this.getType() + ", Amount " + this.getAmount() + ", Balance " + this.getBalance() +       ", Description " + this.getDescription();
  }

}