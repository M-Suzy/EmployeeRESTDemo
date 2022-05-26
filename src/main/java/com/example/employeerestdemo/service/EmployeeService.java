package com.example.employeerestdemo.service;

import com.example.employeerestdemo.dto.EmployeeDto;
import com.example.employeerestdemo.mappers.EmployeeMapper;
import com.example.employeerestdemo.model.Employee;
import com.example.employeerestdemo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 200_000; i++) {
            employees.add(
                    new Employee(
                            "ssn" + i,
                            "firstname" + i,
                            "lastname" + i,
                            i
                    )
            );
        }
            employeeRepository.saveAll(employees);
            return null;


/*
        employeeRepository.saveAll(employees);
        if (employeeRepository.existsBySSN(employee.getSsn())) {
            return Optional.empty();
        }
        Employee employeeToSave = this.employeeMapper.toEmployee(employee);

        Employee savedEmployee = this.employeeRepository.save(employeeToSave);

        return Optional.of(
                this.employeeMapper.toEmployeeDto(savedEmployee)
        );
        */

    }

    public Optional<EmployeeDto> getEmployee(Long id) {

        Optional<Employee> employee = this.employeeRepository.findById(id);
        if (!employee.isPresent()) {
            return Optional.empty();
        }
        return Optional.of(
                this.employeeMapper.toEmployeeDto(employee.get())
        );
    }


}
