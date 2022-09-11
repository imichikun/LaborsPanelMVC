package com.spring.mvc.entity;

import com.spring.mvc.own_annotation.EmailChecker;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "labors")
public class Labor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotBlank (message = "name is a required field")
    @Pattern(regexp = "[a-zA-Z]+", message = "only alphabet letters are permitted")
    @Size(min = 3, message = "name can't be less than 3 symbols")
    private String name;

    @Column(name = "surname")
    @NotBlank (message = "surname is a required field")
    @Pattern(regexp = "[a-zA-Z]+", message = "only alphabet letters are permitted")
    @Size(min = 3, message = "surname can't be less than 3 symbols")
    private String surname;

    @Column(name = "department")
    private String department;

    @Column(name = "salary")
//    @Pattern(regexp = "[\\d]")
//    @Min(value = 500, message = "salary should be in the span of 500 to 1500")
//    @Max(value = 1500, message = "salary should be in the span of 500 to 1500")
    @Range(min = 500, max = 1500, message = "salary should be in the span of 500 to 1500")
    private int salary;

    @Column(name = "email")
    @EmailChecker
    private String email;

    public Labor() {
    }

    public Labor(int id, String name, String surname, String department, int salary, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Labor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", email='" + email + '\'' +
                '}';
    }
}