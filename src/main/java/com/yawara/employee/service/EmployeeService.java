package com.yawara.employee.service;

import com.yawara.employee.dto.EmployeeRequest;
import com.yawara.employee.model.Employee;

public interface EmployeeService {

    //以員工編號查找員工
    Employee getEmployeeById(Integer Id);

    //新增員工資料
    Integer createEmployee(EmployeeRequest employeeRequest);

    void updateEmployeeById(Integer id, EmployeeRequest employeeRequest);

    void deleteEmployeeById(Integer id);
}
