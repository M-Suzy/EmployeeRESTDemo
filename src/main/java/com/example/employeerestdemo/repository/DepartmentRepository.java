package com.example.employeerestdemo.repository;

import com.example.employeerestdemo.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query(
            "SELECT d FROM Department d " +
                    "LEFT JOIN FETCH d.employees WHERE d.id = :id"
    )
    Optional<Department> findDepartmentWithEmployeesById(@Param("id") Long id);
    
}
