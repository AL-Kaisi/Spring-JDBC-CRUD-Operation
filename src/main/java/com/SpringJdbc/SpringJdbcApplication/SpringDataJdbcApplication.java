package com.SpringJdbc.SpringJdbcApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringDataJdbcApplication {

    private static EmployeeDAOInterface<EmployeeDetails> empDAO;

    public SpringDataJdbcApplication(EmployeeDAOInterface<EmployeeDetails> empDAO) {
        this.empDAO = empDAO;
    }

    public static void main(String[] args) {

        SpringApplication.run(SpringDataJdbcApplication.class, args);

        System.out.println("\n**********************Adding and updating*******************\n");

        EmployeeDetails newEmp = new EmployeeDetails(null, "Roger", "Smith",
                "Automation Engineer");
        empDAO.addNewEmployee(newEmp);

        EmployeeDetails empOne = empDAO.getById(1).get();
        empOne.setDesignation("Automation Engineer");
        empOne.setFirstName("Jim");

        empDAO.updateEmployee(empOne);

        List<EmployeeDetails> employees = empDAO.list();

        for (EmployeeDetails row : employees){
            System.out.println("Employee ID:" + row.getEmployeeId());
            System.out.println("First Name: " + row.getFirstName());
            System.out.println("lastName: " + row.getLastName());
            System.out.println("Designation: " + row.getDesignation());
            System.out.println();


        }

//        System.out.println("\n**********************Getting data by Id*******************\n");
//
//        Optional<EmployeeDetails> employee = empDAO.getById(2);
//        System.out.println(employee.get());

        //System.out.println("\n**********************Employee List*******************\n");

//        List<EmployeeDetails> employees = empDAO.list();
//
//        for (EmployeeDetails row : employees) {
//            System.out.println("Employee ID: " + row.getEmployeeId());
//            System.out.println("First Name: " + row.getFirstName());
//            System.out.println("Last Name:" + row.getLastName());
//            System.out.println("Designation: " + row.getDesignation());
//            System.out.println();
//        }


    }


//	@Override
    //public void run(String... args) throws Exception {
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
    //}
}
