package com.cabinvoicegenerator;

public class CabInvoiceException extends Exception {
    public enum ExceptionType {
        USER_EXISTS_ALREADY
    }
    public ExceptionType exceptionType;

    public CabInvoiceException(ExceptionType exceptionType, String message) {
        super(message);
        this.exceptionType = exceptionType;
    }
}
