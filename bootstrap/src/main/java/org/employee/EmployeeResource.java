package org.employee;

import org.employee.model.Employee;
import org.employee.model.Employees;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeResource {

    @GetMapping
    public ResponseEntity<Employees> getAllemployees() {
        List<Employee> employeesList = new ArrayList<>();
        employeesList.add(Employee.builder().id(1).name("John Doe").build());
        Employees employees = Employees.builder().employeeList(employeesList).build();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
