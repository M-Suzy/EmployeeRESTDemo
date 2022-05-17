package com.example.employeerestdemo.mappers;

import com.example.employeerestdemo.dto.DepartmentDto;
import com.example.employeerestdemo.model.Department;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DepartmentMapper {
    public Department toDepartment(DepartmentDto departmentDto) {
        Department department = new Department();
        department.setName(department.getName());
        department.setFoundationDate(departmentDto.getFoundationDate());

        return department;
    }

    public DepartmentDto toDepartmentDto(Department department) {
        DepartmentDto departmentDto = new DepartmentDto();

        departmentDto.setFoundationDate(department.getFoundationDate());
        departmentDto.setName(department.getName());

        return departmentDto;
    }

    public List<DepartmentDto> mapAllToDepartmentDto(List<Department> departments) {
        return departments.stream()
                .map(this::toDepartmentDto)
                .collect(Collectors.toList());
    }
}
