package com.employee.employeemangement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employeemangement.DTO.EmployeeReqDTO;
import com.employee.employeemangement.DTO.EmployeeResDTO;
import com.employee.employeemangement.Service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class Employeecontroller {

    @Autowired 
    private EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<EmployeeResDTO> createEmployee(@RequestBody EmployeeReqDTO dto) {
       EmployeeResDTO employeeResDTO = employeeService.createEmployee(dto);
       return new ResponseEntity<>(employeeResDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EmployeeResDTO> getEmployee(@PathVariable Long id) {
        EmployeeResDTO employeeResDTO = employeeService.getEmployee(id);
        return new ResponseEntity<>(employeeResDTO, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeResDTO>> getAllEmployees() {
        List<EmployeeResDTO> employeeResDTOs = employeeService.getAllEmployees();
        return new ResponseEntity<>(employeeResDTOs, HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeResDTO> updateEmployee(@PathVariable Long id, @RequestBody EmployeeReqDTO dto) {
        EmployeeResDTO employeeResDTO = employeeService.updateEmployee(id, dto);
        return new ResponseEntity<>(employeeResDTO, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
    }





















//    @PostMapping("/create")
//    public ResponseEntity<EmployeeResDTO> createEmployee(@RequestBody EmployeeReqDTO dto) {
//        EmployeeResDTO created = employeeService.createEmployee(dto);
//        return new ResponseEntity<>(created, HttpStatus.CREATED);
//    }
//
//    @GetMapping("/get/{id}")
//    public ResponseEntity<EmployeeResDTO> retrieveEmployee(@PathVariable Long id) {
//        EmployeeResDTO employee = employeeService.getEmployee(id);
//        return ResponseEntity.ok(employee);
//    }
//
//    @GetMapping("/all")
//    public ResponseEntity<List<EmployeeResDTO>> getAllEmployees() {
//        List<EmployeeResDTO> employees = employeeService.getAllEmployees();
//        return ResponseEntity.ok(employees);
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<EmployeeResDTO> updateEmployee(@PathVariable Long id, @RequestBody EmployeeReqDTO dto) {
//        EmployeeResDTO updated = employeeService.updateEmployee(id, dto);
//        return ResponseEntity.ok(updated);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
//        employeeService.deleteEmployee(id);
//        return ResponseEntity.ok("Employee deleted successfully");
//    }
}
