package com.example.employeerestdemo.service;

import com.example.employeerestdemo.dto.EmployeeDto;
import com.example.employeerestdemo.mappers.EmployeeMapper;
import com.example.employeerestdemo.model.Employee;
import com.example.employeerestdemo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    public Optional<EmployeeDto> createEmployee(EmployeeDto employee) {
        if (employeeRepository.existsBySSN(employee.getSsn())) {
            return Optional.empty();
        }
        Employee employeeToSave = this.employeeMapper.toEmployee(employee);

        Employee savedEmployee = this.employeeRepository.save(employeeToSave);

        return Optional.of(
                this.employeeMapper.toEmployeeDto(savedEmployee)
        );
    }

    public Optional<EmployeeDto> getEmployee(Long id) {

        Optional<Employee> employee = this.employeeRepository.findById(id);
        if (employee.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(
                this.employeeMapper.toEmployeeDto(employee.get())
        );
    }


}
