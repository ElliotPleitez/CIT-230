package Eleven.Eight;

public class ElevenEightException extends Exception {
    String exception;
    Account account;

    public enum ExceptionType {
        Overdraft,
        Invalid;
    }

    // Generic Exception
    public ElevenEightException() {

    }

    //
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
        default:
            this.exception = "Default exception";
            break;
        }
    }
}
