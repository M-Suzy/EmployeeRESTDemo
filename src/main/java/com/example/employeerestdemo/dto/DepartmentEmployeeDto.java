package com.example.employeerestdemo.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentEmployeeDto {
    private DepartmentDto department;
    private List<EmployeeDto> employeeDto;
}
