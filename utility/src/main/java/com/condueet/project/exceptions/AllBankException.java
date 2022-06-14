package com.condueet.project.exceptions;

public class AllBankException extends Exception{
    public AllBankException() {
        super();
    }

    public AllBankException(String message) {
        super(message);
    }

    public AllBankException(String message, Throwable cause) {
        super(message, cause);
    }

    public AllBankException(Throwable cause) {
        super(cause);
    }

    protected AllBankException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
