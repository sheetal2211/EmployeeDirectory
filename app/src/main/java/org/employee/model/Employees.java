package org.employee.model;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employees {
    List<Employee> employeeList;
}
