package com.employee.employeemangement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.employeemangement.model.Employee;

@Repository
public interface Employeerepo extends JpaRepository<Employee, Long> {
    boolean existsByEmail(String email);
}
