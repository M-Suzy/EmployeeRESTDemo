package com.example.employeerestdemo.responses;

import com.example.employeerestdemo.dto.EmployeeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class EmployeeLookupResponse {
    private EmployeeDto employeeDto;

    public EmployeeLookupResponse(EmployeeDto employeeDto) {
        this.employeeDto = employeeDto;
    }

    public ResponseEntity<?> onFailure() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee with given properties does not exist.");
    }

    public ResponseEntity<EmployeeDto> onSuccess() {
        return ResponseEntity.ok().body(employeeDto);
    }
}
