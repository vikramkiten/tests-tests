package com.verizon.controller;

import com.verizon.entities.Employee;
import com.verizon.exceptions.EmployeeNotFoundException;
import com.verizon.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
        String response = employeeService.addEmployee(employee);

        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee){
        String response = employeeService.updateEmployee(id,employee);

        return new ResponseEntity<String>(response, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeEmployee(@PathVariable("id") long id){


        String response = employeeService.removeEmployee(id);

        return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") long id){
        Optional<Employee> response = employeeService.getEmployee(id);
        if (!response.isPresent())
        {
            throw new EmployeeNotFoundException("employee with id - "+id+ " not found");
        }
        return  new ResponseEntity<Employee>(response.get(), HttpStatus.OK);
    }



    @GetMapping("/")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = new ArrayList<>(employeeService.getAllEmployees());
        return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
    }
}
