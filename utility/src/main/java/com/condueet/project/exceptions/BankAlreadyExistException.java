package com.condueet.project.exceptions;

public class BankAlreadyExistException extends AllBankException{
    public BankAlreadyExistException() {
        super();
    }

    public BankAlreadyExistException(String message) {
        super(message);
    }

    public BankAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public BankAlreadyExistException(Throwable cause) {
        super(cause);
    }

    protected BankAlreadyExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
