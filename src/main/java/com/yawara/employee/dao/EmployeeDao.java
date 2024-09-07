package com.yawara.employee.dao;

import com.yawara.employee.dto.EmployeeRequest;
import com.yawara.employee.model.Employee;

public interface EmployeeDao {

    //以員工編號查找員工資料
    Employee getEmployeeById(Integer Id);

    //新增員工資料
    Integer createEmployee(EmployeeRequest employeeRequest);

    void updateEmployeeById(Integer id, EmployeeRequest employeeRequest);

    void deleteEmployeeById(Integer id);
}
