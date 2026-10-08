package com.employee.employeemangement.Exception;


public class EmployeeAlreadyExistsException extends RuntimeException {
    public EmployeeAlreadyExistsException(String email) {
        super(email+": Employee with this email already exists");
    }
}
