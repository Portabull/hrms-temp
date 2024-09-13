package com.portabull.exception;

public class HRMSException extends RuntimeException {

    public HRMSException(String message) {
        super(message);
    }

    public HRMSException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
