package Eleven.Eight;

//This is a class to handle various exceptions

public class ElevenEightException extends Exception {
    //exception is intended for future
    String exception;
    //account is reference to the calling exception so method can be retried
    Account account;

    //exception constants
    public enum ExceptionType {
        Overdraft,
        Invalid,
        Negative;
    }

    //Based on which exception was thrown, catch the exception and retry if necessary
    public ElevenEightException(ExceptionType exceptionType, Account account){
        switch(exceptionType){
        case Overdraft:
            this.exception = "Cannot overdraft";
//            try {
//                account.makeWithdrawal();
//            } catch (ElevenEightException e) {
//                //System.out.println("Withdraw failed because of an error");
//            }
            break;
        case Invalid:
            this.exception = "Invalid entry";
//            try {
//                account.makeDeposit();
//            } catch (ElevenEightException e) {
//                //System.out.println("Deposit failed because of an error");
//            }
        case Negative:
            this.exception = "Negative";
//            try {
//                account.makeDeposit();
//            } catch (ElevenEightException e) {
//                //System.out.println("Deposit/Withdraw failed because of an error");
//            }
        default:
            this.exception = "Default exception";
            break;
        }
    }
}
