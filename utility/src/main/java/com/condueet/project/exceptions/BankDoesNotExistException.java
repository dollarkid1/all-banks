package com.condueet.project.exceptions;

public class BankDoesNotExistException extends AllBankException{
    public BankDoesNotExistException() {
        super();
    }

    public BankDoesNotExistException(String message) {
        super(message);
    }

    public BankDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public BankDoesNotExistException(Throwable cause) {
        super(cause);
    }

    protected BankDoesNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
