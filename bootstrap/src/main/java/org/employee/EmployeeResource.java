package org.employee;

import org.employee.model.Employee;
import org.employee.model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeResource {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<Employees> getAllemployees() {
        List<Employee> employeesList = employeeService.getAllEmployees();
        Employees employees = Employees.builder().employeeList(employeesList).build();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee emp = employeeService.createEmployee(employee.toEntity());
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }
}
