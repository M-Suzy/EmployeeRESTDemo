package com.example.employeerestdemo.mappers;

import com.example.employeerestdemo.dto.EmployeeDto;
import com.example.employeerestdemo.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeMapper {
    public Employee toEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();

        employee.setFirstName(employeeDto.getFirstname());
        employee.setLastName(employeeDto.getLastname());
        employee.setSSN(employeeDto.getSsn());
        employee.setAge(employeeDto.getAge());

        return employee;
    }

    public EmployeeDto toEmployeeDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setFirstname(employee.getFirstName());
        employeeDto.setLastname(employee.getLastName());
        employeeDto.setSsn(employee.getSSN());
        employeeDto.setAge(employee.getAge());

        return employeeDto;
    }

    public List<EmployeeDto> mapAllToEmployeeDto(List<Employee> employees) {
        return employees.stream()
                .map(this::toEmployeeDto)
                .collect(Collectors.toList());
    }
}
