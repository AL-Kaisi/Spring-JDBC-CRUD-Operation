package com.SpringJdbc.SpringJdbcApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringDataJdbcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJdbcApplication.class, args);
	}

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... args) throws Exception {
		// create a table
	/*	String query ="create table if not exists EmployeeDetails (\n" +
				"\t\t\t\t employeeId int primary key,\n" +
				"\t\t\t\t firstName varchar(100),\n" +
				"\t\t\t\t lastName varchar(100),\n" +
				"\t\t\t\t designation varchar(100));";
		jdbcTemplate.execute(query);*/

		//insert to table
//		String query ="INSERT INTO EmployeeDetails VALUES(?,?,?,? );";
//		jdbcTemplate.update(query,11023394,"Janes","Powell","Software Engineer");
//		jdbcTemplate.update(query,11023395,"Abby","Cruz","Senior Software Engineer");
//		jdbcTemplate.update(query,11023396,"Kathy","Jones","Software Engineer");

		// update query
		// String query ="UPDATE EmployeeDetails SET designation = ? where employeeId = ?";
		//jdbcTemplate.update(query,"Senior Software Engineer",11023396);

//		// Select query
//		String query ="SELECT * FROM EmployeeDetails";
//		System.out.println("\n**********************\n");
//		System.out.println("List of employees: ");
//
//		List employeeList = jdbcTemplate.queryForList(query);
//		for (Object emp: employeeList){
//			System.out.println(emp.toString());
//		}
//		System.out.println("\n**********************\n");

		// Delete query
//		String query ="DELETE FROM EmployeeDetails where employeeId = ?";
//		jdbcTemplate.update(query,11023395);
//		System.out.println("Delete of employee is complete");
//
//		query ="SELECT * FROM EmployeeDetails";
//		System.out.println("\n**********************\n");
//		System.out.println("List of employees: ");
//
//		List employeeList = jdbcTemplate.queryForList(query);
//		for (Object emp: employeeList){
//			System.out.println(emp.toString());
//		}
//		System.out.println("\n**********************\n");
	}
}