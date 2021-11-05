package com.SpringJdbc.SpringJdbcApplication;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("EmployeeDetails")
public class EmployeeDetails {

    @Id
    @Column("employeeId")
    private Integer employeeId;


    @Column("firstName")
    private String firstName;
    @Column("lastName")
    private String lastName;
    @Column("designation")
    private String designation;

    public EmployeeDetails() {

    }

    public EmployeeDetails(Integer employeeId, String firstName, String lastName, String designation) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.designation = designation;
    }

    static EmployeeDetails create(Integer employeeId, String firstName, String lastName, String designation) {
        return new EmployeeDetails(employeeId, firstName, lastName, designation);
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "EmployeeDetails{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }
}
