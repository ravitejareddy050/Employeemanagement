package com.employee.employeemangement.DTO;

import java.sql.Date;

public class EmployeeResDTO {
    private Long id;
    private String name;
    private String department;
    private String email;
    private double salary;
    private Date doj;

    public EmployeeResDTO() {
    }

    public EmployeeResDTO(Long id, String name) {
        this.id = id;
        this.name = name;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(String department) {
//        this.department = department;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public double getSalary() {
//        return salary;
//    }
//
//    public void setSalary(double salary) {
//        this.salary = salary;
//    }
//
//    public Date getDoj() {
//        return doj;
//    }
//
//    public void setDoj(Date doj) {
//        this.doj = doj;
//    }
}
