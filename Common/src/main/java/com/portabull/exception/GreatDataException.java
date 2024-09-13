package com.portabull.exception;

import java.util.Arrays;
import java.util.List;

public class GreatDataException extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private int code;
    private String errorMessage;
    private List<String> details;
    //private String message;

    /*public GreatDataException() {
        super();
    }*/

   /* public GreatDataException(String message) {
        super();
        this.message = message;
    }*/


    public GreatDataException(int code, String errorMessage) {
        super();
        this.errorMessage = errorMessage;
        this.code = code;
    }

   /* @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }*/

    public GreatDataException(int code, String errorMessage, String details) {
        super();
        this.code = code;
        this.errorMessage = errorMessage;
        this.details = Arrays.asList(details);
    }

    public GreatDataException(int code, String errorMessage, List<String> details) {
        super();
        this.code = code;
        this.errorMessage = errorMessage;
        this.details = details;
    }

    public GreatDataException(int code, List<String> details) {
        super();
        this.code = code;
        this.details = details;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        StringBuilder errorMessageToPrint = new StringBuilder("GreatDataException : ");
        errorMessageToPrint.append(errorMessage);

        if (this.details != null && !this.details.isEmpty()) {
            this.details.forEach(detail -> {
                errorMessageToPrint.append(":").append(detail);
            });
        }

        return errorMessageToPrint.toString();
    }
}
