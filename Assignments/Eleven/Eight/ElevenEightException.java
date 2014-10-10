package Eleven.Eight;

public class ElevenEightException extends Exception {
    String exception;
    Account account;

    public enum ExceptionType {
        Overdraft,
        Invalid,
        Negative;
    }

    //Generic Constructor
    public ElevenEightException(ExceptionType exceptionType, Account account){
        switch(exceptionType){
        case Overdraft:
            this.exception = "Cannot overdraft";
            break;
        case Invalid:
            this.exception = "Invalid entry";
            try {
                account.makeDeposit();
            } catch (ElevenEightException e) {
                //System.out.println("Deposit failed because of an error");
            }
        case Negative:
            this.exception = "Negative";
            try {
                account.makeDeposit();
            } catch (ElevenEightException e) {
                //System.out.println("Deposit failed because of an error");
            }
        default:
            this.exception = "Default exception";
            break;
        }
    }
}
