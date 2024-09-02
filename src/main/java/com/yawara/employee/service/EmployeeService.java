package com.yawara.employee.service;

import com.yawara.employee.model.Employee;
import org.springframework.stereotype.Component;

public interface EmployeeService {

    Employee getEmployeeById(int id);

}
