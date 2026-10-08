package com.employee.employeemangement.Exception;

public class EmployeeNotFound extends RuntimeException {
    public EmployeeNotFound() {
        super("The employee is not found in the database");
    }
}
