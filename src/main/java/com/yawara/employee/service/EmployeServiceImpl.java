package com.yawara.employee.service;

import com.yawara.employee.dao.EmployeeDao;
import com.yawara.employee.dao.EmployeeDaoImpl;
import com.yawara.employee.dto.EmployeeRequest;
import com.yawara.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDao employeeDao;

    //以員工編號查找員工
    @Override
    public Employee getEmployeeById(Integer Id) {
       return employeeDao.getEmployeeById(Id);
    }

    //新增員工資料
    @Override
    public Integer createEmployee(EmployeeRequest employeeRequest) {
        return employeeDao.createEmployee(employeeRequest);
    }

    @Override
    public void updateEmployeeById(Integer id, EmployeeRequest employeeRequest) {
        employeeDao.updateEmployeeById(id, employeeRequest);
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        employeeDao.deleteEmployeeById(id);
    }
}
