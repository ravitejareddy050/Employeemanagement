package com.employee.employeemangement.Exception;

public class SalaryException extends RuntimeException {
    public SalaryException() {
        super("The salary cant be negative or zero");
    }
}
