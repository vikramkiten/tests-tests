package com.verizon.repositories;

import com.verizon.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {

    public Optional<Employee> findByEmployeeId(String employeeId);


}
