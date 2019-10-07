package com.verizon.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Indexed;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "Employee_Data")
public class Employee {


    @Id
    @GeneratedValue
    private long id;

//    @Min(3)
    @NotNull
//    @Column(unique = true)
    private String employeeId;

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private String middleName;

    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    @NotNull
    @Pattern(regexp = "(^$|[0-9]{10})")
    private String phone;

    @NotNull
    private String designation;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPhone(String phone) {

        this.phone = phone;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Employee(long id, String employeeId, String firstName, String lastName, String middleName, String email, String phone, String designation) {
        this.id = id;
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.email = email;
        this.phone = phone;
        this.designation = designation;
    }

    public Employee( String employeeId, String firstName, String lastName,  String email, String phone, String designation) {

        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;

        this.email = email;
        this.phone = phone;
        this.designation = designation;
    }

    public Employee() {
    }


    @Override
    public boolean equals(Object obj) {
        Employee employee = (Employee) obj;
        return employee.employeeId == this.employeeId;
    }

}
