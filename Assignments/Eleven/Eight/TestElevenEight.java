package Eleven.Eight;

//import java.util.ArrayList;

public class TestElevenEight {

	public static void main(String[] args) {
		//System.out.println("Transaction History\n" + account.toString() + "\n\n");
		//ArrayList<Double> arrayList = new ArrayList<Double>();
		//arrayList.set(5, 6.0);
		
		Account account = new Account("George", 1122, 1000);
		account.setAnnualInterestRate(1.5);

		for(int i = 0; i < 1; i++){
	        try {
	            account.makeDeposit(); //30, 40, 50
	        } catch (ElevenEightException e) {
	            //System.out.println("Deposit failed because of an error.");
	        }
            System.out.println("Deposit Statement\nAccount name\t: " + account.getName() + "\nInterest rate\t: " + account.getAnnualInterestRate() + "%" + "\nBalance\t\t: $" + account.getBalance() + "\n----------------------------------------\n\n");
		}

		for(int i = 0; i < 0; i++){
	        account.makeWithdrawal(); //5, 4, 2
		}
        System.out.println("Withdrawal Statement\nAccount name\t: " + account.getName() + "\nInterest rate\t: " + account.getAnnualInterestRate() + "%" + "\nBalance\t\t: $" + account.getBalance() + "\n----------------------------------------\n\n");            
	}
}
