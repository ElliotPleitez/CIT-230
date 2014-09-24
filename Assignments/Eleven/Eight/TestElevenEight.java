package Eleven.Eight;

public class TestElevenEight {

	public static void main(String[] args) {
		Account account = new Account("George", 1122, 1000);
		account.setAnnualInterestRate(1.5);

		account.makeDeposit(); //30
		System.out.println("Deposit Statement\nAccount name\t: " + account.getName() + "\nInterest rate\t: " + account.getAnnualInterestRate() + "%" + "\nBalance\t\t: $" + account.getBalance() + "\n----------------------------------------\n\n");
		account.makeDeposit(); //40
		System.out.println("Deposit Statement\nAccount name\t: " + account.getName() + "\nInterest rate\t: " + account.getAnnualInterestRate() + "%" + "\nBalance\t\t: $" + account.getBalance() + "\n----------------------------------------\n\n");
		account.makeDeposit(); //50
		System.out.println("Deposit Statement\nAccount name\t: " + account.getName() + "\nInterest rate\t: " + account.getAnnualInterestRate() + "%" + "\nBalance\t\t: $" + account.getBalance() + "\n----------------------------------------\n\n");
		
		account.makeWithdrawal(); //5
		System.out.println("Withdrawal Statement\nAccount name\t: " + account.getName() + "\nInterest rate\t: " + account.getAnnualInterestRate() + "%" + "\nBalance\t\t: $" + account.getBalance() + "\n----------------------------------------\n\n");
		account.makeWithdrawal(); //4
		System.out.println("Withdrawal Statement\nAccount name\t: " + account.getName() + "\nInterest rate\t: " + account.getAnnualInterestRate() + "%" + "\nBalance\t\t: $" + account.getBalance() + "\n----------------------------------------\n\n");
		account.makeWithdrawal(); //2
		System.out.println("Withdrawal Statement\nAccount name\t: " + account.getName() + "\nInterest rate\t: " + account.getAnnualInterestRate() + "%" + "\nBalance\t\t: $" + account.getBalance() + "\n----------------------------------------\n\n");
		
		System.out.println("Transaction History\n" + account.toString() + "\n\n");
		
	}

}
