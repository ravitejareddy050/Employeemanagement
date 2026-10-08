package com.employee.employeemangement.Service;

import java.util.ArrayList;
import java.util.List;

import com.employee.employeemangement.Exception.EmployeeNotFound;
import com.employee.employeemangement.Exception.EmployeeAlreadyExistsException;
import com.employee.employeemangement.Exception.SalaryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.employeemangement.DTO.EmployeeReqDTO;
import com.employee.employeemangement.DTO.EmployeeResDTO;
import com.employee.employeemangement.Repository.Employeerepo;
import com.employee.employeemangement.model.Employee;

@Service
public class EmployeeService {

    private final Employeerepo employeerepo;
    public EmployeeService(Employeerepo employeerepo) {
        this.employeerepo = employeerepo;
    }

    public EmployeeResDTO createEmployee(EmployeeReqDTO dto) {
        if(employeerepo.existsByEmail(dto.getEmail())) {
            throw new EmployeeAlreadyExistsException(dto.getEmail());
        }
        if(dto.getSalary() < 0) {
            throw new SalaryException();
        }
        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setDepartment(dto.getDepartment());
        employee.setSalary(dto.getSalary());
        employee.setDoj(dto.getDoj());
        employee.setPassword(dto.getPassword());
        employeerepo.save(employee);
        EmployeeResDTO responseDTO = new EmployeeResDTO();
        responseDTO.setId(employee.getId());
        responseDTO.setName(dto.getName());
        return responseDTO;
    }

    public EmployeeResDTO getEmployee(Long id) {
        Employee employee = employeerepo.findById(id)
                .orElseThrow(() -> new EmployeeNotFound());
        EmployeeResDTO responseDTO = new EmployeeResDTO();
        responseDTO.setId(employee.getId());
        responseDTO.setName(employee.getName());
        return responseDTO;
    }

    public List<EmployeeResDTO> getAllEmployees() {
        List<Employee> employees = employeerepo.findAll();
        List<EmployeeResDTO> responseDTOs = new ArrayList<>();
        for (Employee employee : employees) {
            EmployeeResDTO responseDTO = new EmployeeResDTO();
            responseDTO.setId(employee.getId());
            responseDTO.setName(employee.getName());
            responseDTOs.add(responseDTO);
        }
        return responseDTOs;
    }

    public EmployeeResDTO updateEmployee(Long id, EmployeeReqDTO dto) {
        if(employeerepo.existsByEmail(dto.getEmail())) {
            throw new EmployeeAlreadyExistsException(dto.getEmail());
        }
        if(dto.getSalary() < 0) {
            throw new SalaryException();
        }
        Employee employee = employeerepo.findById(id)
                .orElseThrow(EmployeeNotFound::new);

        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setDepartment(dto.getDepartment());
        employee.setSalary(dto.getSalary());
        employee.setDoj(dto.getDoj());
        employeerepo.save(employee);
        EmployeeResDTO responseDTO = new EmployeeResDTO();
        responseDTO.setId(employee.getId());
        responseDTO.setName(employee.getName());
        return responseDTO;
    }

    public void deleteEmployee(Long id) {
        Employee employee = employeerepo.findById(id)
                .orElseThrow(() -> new EmployeeNotFound());
        employeerepo.delete(employee);
    }
}
