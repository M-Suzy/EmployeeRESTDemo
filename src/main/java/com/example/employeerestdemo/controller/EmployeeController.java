package com.example.employeerestdemo.controller;


import com.example.employeerestdemo.dto.EmployeeDto;
import com.example.employeerestdemo.responses.EmployeeCreationResponse;
import com.example.employeerestdemo.responses.EmployeeLookupResponse;
import com.example.employeerestdemo.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    EmployeeService employeeService;

    EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeDto employee) {
        Assert.notNull(employee, "Employee passed is null!");
        Optional<EmployeeDto> emp = employeeService.createEmployee(employee);
        if (emp.isEmpty()) {
            return new EmployeeCreationResponse(employee).onFailure();
        }
        return new EmployeeCreationResponse(emp.get()).onSuccess();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable("id") Long id) {
        Optional<EmployeeDto> emp = employeeService.getEmployee(id);
        if (emp.isPresent()) {
            return new EmployeeLookupResponse(emp.get()).onSuccess();
        }
        return new EmployeeLookupResponse(null).onFailure();
    }




}
