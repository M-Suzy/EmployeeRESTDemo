package com.example.employeerestdemo.model;

import lombok.AllArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "employee", uniqueConstraints = {
        @UniqueConstraint(columnNames = "SSN",
                name = "SSN_UK")})

public class Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name="ssn", length = 50,
            nullable = false, unique = true)
    private String SSN;

    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;
    @Column(nullable = false)
    private int age;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Contract contract;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id",
            foreignKey = @ForeignKey(name = "department_employee_fk"))
    private Department department;


    public Employee(){}

    public Employee(String ssn, String firstName, String lastName,  int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.SSN = ssn;
        this.age = age;
    }


    public Long getId() {
        return id;
    }

    public String getSSN() {
        return SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Contract getContract() {
        return contract;
    }

    public Department getDepartment() {
        return department;
    }
}
