package com.example.employeerestdemo.service;

import com.example.employeerestdemo.dto.DepartmentDto;
import com.example.employeerestdemo.dto.EmployeeDto;
import com.example.employeerestdemo.mappers.DepartmentMapper;
import com.example.employeerestdemo.mappers.EmployeeMapper;
import com.example.employeerestdemo.model.Department;
import com.example.employeerestdemo.model.Employee;
import com.example.employeerestdemo.repository.DepartmentRepository;
import com.example.employeerestdemo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    private final EmployeeMapper employeeMapper;

    private final DepartmentMapper departmentMapper;

    public DepartmentService(DepartmentRepository departmentRepository, EmployeeMapper employeeMapper,
                             EmployeeRepository employeeRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.employeeMapper = employeeMapper;
        this.departmentMapper = departmentMapper;
    }

    public List<EmployeeDto> getEmployees(Long departmentId) {

        Optional<Department> department = this.departmentRepository.findDepartmentWithEmployeesById(departmentId);
        if(department.isEmpty()){
            return Collections.emptyList();
        }
        List<Employee> employees = department.get().getEmployees();
        return employeeMapper.mapAllToEmployeeDto(employees);
    }

    public List<DepartmentDto> getDepartments() {
        return departmentMapper.mapAllToDepartmentDto(departmentRepository.findAll());
    }
}
