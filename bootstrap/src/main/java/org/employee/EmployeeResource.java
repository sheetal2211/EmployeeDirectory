package org.employee;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.employee.model.Employee;
import org.employee.model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@Tag(name = "Employee", description = "operations related to Employee Resource")
public class EmployeeResource {

    @Autowired
    EmployeeService employeeService;

    @Operation(summary = "Fetch all employees",
            description = "fetches all employees entities and their data from data source")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @GetMapping(produces = "application/json")
    public ResponseEntity<Employees> getAllEmployees() {
        List<Employee> employeesList = employeeService.getAllEmployees();
        Employees employees = Employees.builder().employeeList(employeesList).build();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @Operation(summary = "Delete an existing employee",
            description = "delete an existing employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "successfully deleted an employee"),
            @ApiResponse(responseCode = "404", description = "employee not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Create a new employee",
            description = "creates a new employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successfully added an employee")
    })
    @PostMapping(produces = "application/json")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee emp = employeeService.createEmployee(employee.toEntity());
        return new ResponseEntity<>(emp, HttpStatus.CREATED);
    }
}
