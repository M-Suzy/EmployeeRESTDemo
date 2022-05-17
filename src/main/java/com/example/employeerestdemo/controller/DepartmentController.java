package com.example.employeerestdemo.controller;

import com.example.employeerestdemo.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employess")
    public ResponseEntity<?> getEmployees(@PathVariable("id") Long departmentId) {
        return ResponseEntity.ok().body(departmentService.getEmployees(departmentId));
    }
}
