package com.verizon.services;

import com.verizon.entities.Employee;
import com.verizon.exceptions.EmployeeNotFoundException;
import com.verizon.repositories.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDao employeeDao;


    @Override
    public Optional<Employee> getEmployee(long id) {

        return employeeDao.findById(id);
    }



    @Override
    public String addEmployee(Employee employee){
       Optional<Employee> response= employeeDao.findById(employee.getId());
       if (response.isPresent())
       {
           return "Employee Already Exists";
       }

        employeeDao.save(employee);
        return"Employee Added Successfully";

    }

    @Override
    public String updateEmployee(long id,Employee employee) {
        Optional<Employee> response= employeeDao.findById(id);
        Optional<Employee> response2= employeeDao.findByEmployeeId(employee.getEmployeeId());

        if (!response.isPresent() || !response2.isPresent())
        {
            return "Employee Doesn't Exists";
        }
        if (response.isPresent() && response2.isPresent() && response2.get().getId()!=id)
        {
            return "Employee Doesn't Exists for this id";
        }
        employee.setId(id);
        employeeDao.save(employee);
        return"Employee updated Successfully";
    }

    @Override
    public String removeEmployee(long id) {
        Optional<Employee> response= employeeDao.findById(id);
        if (!response.isPresent())
        {
            return "Employee Does Not Exist";
        }
        employeeDao.deleteById(id);
        return "Employee Removed Successfully";
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }



}
