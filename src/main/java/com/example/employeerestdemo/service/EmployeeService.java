package com.example.employeerestdemo.service;

import com.example.employeerestdemo.dto.EmployeeDto;
import com.example.employeerestdemo.mappers.EmployeeMapper;
import com.example.employeerestdemo.model.Employee;
import com.example.employeerestdemo.repository.EmployeeRepository;
import com.example.employeerestdemo.responses.GenericPageableResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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
       /* List<Employee> employees = new ArrayList<>();
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
       */

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
        return employee.map(this.employeeMapper::toEmployeeDto);
    }

    public GenericPageableResponse<EmployeeDto> getEmployees(String firstname, Integer pageNumber, Integer pageSize){
        Assert.notNull(firstname, "Firstname is null!");
        PageRequest pageRequest = PageRequest.of(pageNumber,pageSize,
                Sort.by(Sort.Direction.ASC, "firstName"));
        Page<Employee> employees = employeeRepository.findAllByFirstName(firstname, pageRequest);

        return  new GenericPageableResponse<>(
                employeeMapper.mapAllToEmployeeDto(employees.getContent()),
                employees.getTotalPages(),
                employees.getNumber()
                );
    }


}
