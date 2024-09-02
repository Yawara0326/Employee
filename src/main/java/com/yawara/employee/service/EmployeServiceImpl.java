package com.yawara.employee.service;

import com.yawara.employee.dao.EmployeeDao;
import com.yawara.employee.dao.EmployeeDaoImpl;
import com.yawara.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Employee getEmployeeById(int id) {
       return employeeDao.getEmployeeById(id);
    }
}
