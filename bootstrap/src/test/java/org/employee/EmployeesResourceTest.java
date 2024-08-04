package org.employee;

import org.employee.model.Employee;
import org.employee.model.Employees;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeesResourceTest  {

    @Autowired
    TestRestTemplate template;

    @Test
    public void getEmployees() {
        String url = "/api/v1/employees";
        Employees expectedEmployees= getEmployeesMock();
        ResponseEntity<Employees> response = template.getForEntity(url, Employees.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull().isEqualTo(expectedEmployees);
    }

    private Employees getEmployeesMock() {
        List<Employee> employeesList = new ArrayList<>();
        employeesList.add(Employee.builder().id(1).name("John Doe").build());
        return Employees.builder().employeeList(employeesList).build();
    }
}
