package com.yawara.employee.controller;

import com.yawara.employee.dto.EmployeeRequest;
import com.yawara.employee.model.Employee;
import com.yawara.employee.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //透過員工編號查找員工
    @GetMapping("/Employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id){
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null){
            return ResponseEntity.status(HttpStatus.OK).body(employee);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //新增員工資料
    @PostMapping("/Employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody @Valid EmployeeRequest employeeRequest){
        Integer id = employeeService.createEmployee(employeeRequest);

        Employee employee = employeeService.getEmployeeById(id);

        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    //更新員工資料
    @PutMapping("/Employee/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable Integer id,
                                                       @RequestBody @Valid EmployeeRequest employeeRequest){

        //先透過id檢查該員工存不存在
        Employee employee = employeeService.getEmployeeById(id);

        if (employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        //存在才進行資料更新
        employeeService.updateEmployeeById(id, employeeRequest);

        Employee updatedEmployee = employeeService.getEmployeeById(id);

        return ResponseEntity.status(HttpStatus.OK).body(updatedEmployee);
    }

    //透過id刪除員工資料
    @DeleteMapping("/Employee/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable Integer id){
        employeeService.deleteEmployeeById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
