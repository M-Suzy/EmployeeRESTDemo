package com.example.employeerestdemo.responses;

import com.example.employeerestdemo.dto.EmployeeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



public class EmployeeCreationResponse {
    private EmployeeDto employeeDto;

    public EmployeeCreationResponse(EmployeeDto employeeDto) {
        this.employeeDto = employeeDto;
    }

    public ResponseEntity<?> onFailure() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There is an employee with this SSN.");
    }

    public ResponseEntity<EmployeeDto> onSuccess() {
        return ResponseEntity.ok().body(employeeDto);
    }
}
