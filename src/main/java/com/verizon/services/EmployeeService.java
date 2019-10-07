package com.verizon.services;

import com.verizon.entities.Employee;

import java.util.Optional;
import java.util.List;

public interface EmployeeService {
    public Optional<Employee> getEmployee(long id);
    public String addEmployee(Employee employee);
    public String updateEmployee(long id, Employee employee);
    public String removeEmployee(long id);
    public List<Employee> getAllEmployees();

}
