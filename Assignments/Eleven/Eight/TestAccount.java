//package Eleven.Eight;
//
//import java.util.Scanner;
//
///** This test program for class Account creates an Account with annual interest rate of 1.5%, balance is 1000, id is 1122, and name is George. Deposit $30, $40, and $50 to the account and withdraw $5, $4, and $2 from the account. Then prints an account summary that shows account holder name, interest rate, balance, and all transactions */
//
//class TestAccount {
//
//  // Main method
//  public static void main(String[] args) {
//
//    //Create instance of Account with specified balance, id, and name
//    Account account = new Account("George", 1122, 1000);
//    
//    //Set annual interest rate
//    account.setAnnualInterestRate(1.5);
//
//    // Ask user what to do next. use getUserInput() method
//    Character choice = getUserInput();
//
//    do {
//
//      if (choice == 1) {
//          try{
//              account.makeDeposit();
//          }
//          catch(ElevenEightException ex){}
//        System.out.println();// add spaces between result and choice menu
//        System.out.println();        
//        choice = getUserInput();
//        testInput(choice);
//      }
//        
//      else if (choice == 2) {
//        try{
//            account.makeWithdrawal();
//        }
//        catch(ElevenEightException ex){}
//        System.out.println();// add spaces between result and choice menu
//        System.out.println();
//        choice = getUserInput();
//        testInput(choice);
//      }
//        
//      else if (choice == 3) {
//      
//        System.out.println("Your account balance is: " + account.getBalance());
//        System.out.println();// add spaces between result and choice menu
//        System.out.println();
//        choice = getUserInput();
//        testInput(choice);
//      }
//
//      else if (choice == 4) {
//        
//        System.out.println(account.toString());
//        System.out.println();
//        
//        choice = getUserInput();
//        testInput(choice);
//      }
//    } while (choice != 0);
//    
//    System.out.println("Thank you have a great day!");
//
//  }
//
//  // Create a method to prompt user for input
//  public static Character getUserInput() {
//
//    //Make a transaction. Prompt the user to request what they want to do. 
//    Scanner input = new Scanner(System.in);
//    System.out.println("What do you want to do today?");
//    System.out.println("\tEnter 0 to exit system: " 
//                       + "\n\tEnter 1 to make deposit: " 
//                       + "\n\tEnter 2 to make withdrawal: "
//                       + "\n\tEnter 3 to get balance: "
//                       + "\n\tEnter 4 to print a statement: ");
//    return (char)input.nextInt();
//  }
//  
//  public static void testInput(Character c) {
//	  
//	// Make sure choice is b0etween 0-3 and not letters
//	if (!Character.isDigit(c) && (int)c < 0 && c > 3)
//	      System.out.println("Invalid choice!");
//  }
//
//}