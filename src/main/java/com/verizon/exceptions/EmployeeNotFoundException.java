package com.verizon.exceptions;


public class EmployeeNotFoundException extends RuntimeException{

    String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public EmployeeNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public EmployeeNotFoundException() {
    }
}
