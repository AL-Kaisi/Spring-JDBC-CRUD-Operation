package com.SpringJdbc.SpringJdbcApplication;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeJdbcDAO implements EmployeeDAOInterface<EmployeeDetails>{

    private JdbcTemplate jdbcTemplate;

    RowMapper<EmployeeDetails> rowMap  = (result,num) -> {
        EmployeeDetails employees = new EmployeeDetails();

        employees.setEmployeeId(result.getInt("employeeId"));
        employees.setFirstName(result.getString("firstName"));
        employees.setLastName(result.getString("lastName"));
        employees.setDesignation(result.getString("designation"));

        return employees;
    };

    public EmployeeJdbcDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<EmployeeDetails> list() {
        String query = "SELECT * FROM EmployeeDetails";
        return  jdbcTemplate.query(query,rowMap);
    }



}
