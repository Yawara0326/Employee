package com.yawara.employee.dao;

import com.yawara.employee.dto.EmployeeRequest;
import com.yawara.employee.model.Employee;
import com.yawara.employee.rowmapper.EmployeeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class EmployeeDaoImpl implements EmployeeDao{

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    //以員工編號查找員工
    @Override
    public Employee getEmployeeById(Integer id) {
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

    //新增員工資料
    @Override
    public Integer createEmployee(EmployeeRequest employeeRequest) {
        String sql = "INSERT INTO employee( name, id_number, email, image_url) VALUES (:name, :idNumber, :email, :imageUrl)";

        Map<String, Object> map = new HashMap<>();
        map.put("name", employeeRequest.getName());
        map.put("idNumber", employeeRequest.getIdNumber());
        map.put("email", employeeRequest.getEmail());
        map.put("imageUrl", employeeRequest.getImageUrl());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder, new String[] { "id" });

        int id = keyHolder.getKey().intValue();

        return id;
    }

    @Override
    public void updateEmployeeById(Integer id, EmployeeRequest employeeRequest) {
        String sql = "UPDATE employee SET name = :name, id_number = :idNumber," +
                " email = :email, image_url = :imageUrl " +
                "WHERE id = :id";

        Map<String, Object> map = new HashMap<>();
        map.put("id", id);

        map.put("name", employeeRequest.getName());
        map.put("idNumber", employeeRequest.getIdNumber());
        map.put("email", employeeRequest.getEmail());
        map.put("imageUrl", employeeRequest.getImageUrl());


        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        String sql = "DELETE FROM employee WHERE id = :id";

        Map<String, Object> map = new HashMap<>();
        map.put("id", id);

        namedParameterJdbcTemplate.update(sql, map);
    }
}
