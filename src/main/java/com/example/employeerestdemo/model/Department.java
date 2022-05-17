package com.example.employeerestdemo.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "department_name", nullable = false)
    private String name;

    @Column(name = "foundation_date", nullable = false)
    private LocalDate foundationDate;

    @OneToMany(mappedBy = "department", cascade = CascadeType.PERSIST)
    private List<Employee> employees = new ArrayList<>();

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addEmployee(Employee employee){
        employee.setDepartment(this);
        employees.add(employee);
    }

    public LocalDate getFoundationDate() {
        return foundationDate;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setFoundationDate(LocalDate foundationDate) {
        this.foundationDate = foundationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(foundationDate, that.foundationDate))
            return false;
        return Objects.equals(employees, that.employees);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (foundationDate != null ? foundationDate.hashCode() : 0);
        result = 31 * result + (employees != null ? employees.hashCode() : 0);
        return result;
    }
}