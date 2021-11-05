package com.SpringJdbc.SpringJdbcApplication;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeJdbcDAO implements EmployeeDAOInterface<EmployeeDetails> {

    private JdbcTemplate jdbcTemplate;

    RowMapper<EmployeeDetails> rowMap = (result, num) -> {
        EmployeeDetails employees = new EmployeeDetails();

        employees.setEmployeeId(result.getInt("employeeId"));
        employees.setFirstName(result.getString("firstName"));
        employees.setLastName(result.getString("lastName"));
        employees.setDesignation(result.getString("designation"));

        return employees;
    };

    public EmployeeJdbcDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<EmployeeDetails> list() {
        String query = "SELECT * FROM EmployeeDetails";
        return jdbcTemplate.query(query, rowMap);
    }

    @Override
    public Optional<EmployeeDetails> getById(int id) {
        String query = "SELECT * FROM EmployeeDetails WHERE employeeId = ?";
        EmployeeDetails employee = null;

        try {
            employee = jdbcTemplate.queryForObject(query, rowMap, id);

        } catch (DataAccessException dataAccessException) {
            System.out.println(dataAccessException);

        }
        return Optional.ofNullable(employee);
    }

    @Override
    public void addNewEmployee(EmployeeDetails employeeDetails) {

        String insertQuery = "INSERT INTO EmployeeDetails(firstName,lastName,Designation) " +
                "VALUES (?,?,?)";
        jdbcTemplate.update(insertQuery, employeeDetails.getFirstName(),
                employeeDetails.getLastName(),
                employeeDetails.getDesignation());
    }

    @Override
    public void updateEmployee(EmployeeDetails employeeDetails) {
        String updateQuery = "UPDATE EmployeeDetails SET firstName = ?, " +
                "lastName = ?, designation = ? where employeeId = ? ";

        jdbcTemplate.update(updateQuery,
                employeeDetails.getFirstName(),
                employeeDetails.getLastName(),
                employeeDetails.getDesignation(),
                employeeDetails.getEmployeeId());
    }
}
