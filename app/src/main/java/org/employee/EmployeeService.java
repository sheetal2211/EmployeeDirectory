package org.employee;

import org.employee.entity.EmployeeEntity;
import org.employee.model.Employee;
import org.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeesList = employeeRepository.findAll();
        return employeesList.stream().map(EmployeeEntity::toModel).collect(Collectors.toList());
    }


    Employee createEmployee(EmployeeEntity employee) {
        EmployeeEntity employeeEntity = employeeRepository.save(employee);
        return employeeEntity.toModel();
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
