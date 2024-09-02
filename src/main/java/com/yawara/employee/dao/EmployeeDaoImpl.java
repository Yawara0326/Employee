package com.yawara.employee.dao;

import com.yawara.employee.model.Employee;
import com.yawara.employee.rowmapper.EmployeeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class EmployeeDaoImpl implements EmployeeDao{

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Employee getEmployeeById(int id) {
        String sql = "SELECT  id, name, id_number, email, image_url FROM employee WHERE id = :id";

        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        List<Employee> employeeList = namedParameterJdbcTemplate.query(sql, map, new EmployeeRowMapper());

        if (employeeList.size()>0){
            return employeeList.get(0);
        }else{
            return null;
        }
    }
}
