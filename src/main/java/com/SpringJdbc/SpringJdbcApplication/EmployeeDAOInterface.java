package com.SpringJdbc.SpringJdbcApplication;
import java.util.List;

public interface EmployeeDAOInterface<Table> {

    List<Table> list();

}
