package org.employee;

import org.assertj.core.api.recursive.comparison.RecursiveComparisonConfiguration;
import org.employee.entity.EmployeeEntity;
import org.employee.model.Employee;
import org.employee.model.Employees;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeesResourceTest  {

    @Autowired
    TestRestTemplate template;

    @MockBean
    private EmployeeService employeeService;

    @Test
    public void saveEmployees() {
        //Given
        String url = "/api/v1/employees";
        Mockito.lenient().when(employeeService.createEmployee(getEmployeeEntityMock())).thenReturn(getEmployee());

        //When
        ResponseEntity<Employee> response = template.postForEntity(url, getEmployeeEntityMock(), Employee.class);

        //Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull().usingRecursiveAssertion().ignoringFields("id").isEqualTo(getEmployee());
    }

    @Test
    public void getEmployees() {
        String url = "/api/v1/employees";
        List<Employee> employees = List.of(getEmployee());
        Mockito.lenient().when(employeeService.getAllEmployees()).thenReturn(employees);

        //When
        ResponseEntity<Employees> response = template.getForEntity(url, Employees.class);

        //Then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getEmployeeList()).isNotNull().contains(getEmployee());
    }

    private Employee getEmployee() {
        return Employee.builder().name("Jane Doe").build();
    }

    private EmployeeEntity getEmployeeEntityMock() {
        return EmployeeEntity.builder().id(Long.valueOf(1)).name("Jane Doe").build();
    }
}
