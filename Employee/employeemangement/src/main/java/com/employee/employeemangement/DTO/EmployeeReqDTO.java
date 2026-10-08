package com.employee.employeemangement.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.sql.Date;

public class EmployeeReqDTO {
    @NotBlank
    private String name;
    @Email
    private String email;
    private String department;
    @Positive
    private double salary;
    @NotBlank
    private Date doj;
    @NotBlank
    private String password;

    public EmployeeReqDTO() {
    }

    public EmployeeReqDTO(String name, String email, String department, double salary, Date doj, String password) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.salary = salary;
        this.doj = doj;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
