package com.yawara.employee.controller;

import com.yawara.employee.dao.EmployeeDao;
import com.yawara.employee.model.Employee;
import com.yawara.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("Employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null){
            return ResponseEntity.status(HttpStatus.OK).body(employee);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
