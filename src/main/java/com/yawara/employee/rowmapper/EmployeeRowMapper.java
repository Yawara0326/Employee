package com.yawara.employee.rowmapper;

import com.yawara.employee.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getInt("id"));
        employee.setName(rs.getString("name"));
        employee.setIdNumber(rs.getString("id_number"));
        employee.setEmail(rs.getString("email"));
        employee.serImageUrl(rs.getString("image_url"));
        return employee;
    }
}
