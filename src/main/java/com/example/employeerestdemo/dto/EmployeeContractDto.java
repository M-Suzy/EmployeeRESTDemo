package com.example.employeerestdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeContractDto {
    private EmployeeDto employeeDto;
    private ContractDto contractDto;
}
