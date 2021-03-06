package com.example.employeerestdemo.repository;

import com.example.employeerestdemo.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    boolean existsBySSN(String ssn);
    @Query("SELECT e FROM Employee e WHERE e.department.id = :id")
    List<Employee> findAllByDepartmentId(@Param("id") Long id);

    @Query(
            "SELECT e FROM Employee e " +
                    "WHERE LOWER(e.firstName) LIKE LOWER(CONCAT(:firstName, '%'))"
    )
    Page<Employee> findAllByFirstName(String firstName, Pageable pageable);
}
