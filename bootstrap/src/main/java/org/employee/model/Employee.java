package org.employee.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.employee.entity.EmployeeEntity;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    int id;
    String name;

    public EmployeeEntity toEntity() {
        return EmployeeEntity.builder().id(Long.valueOf(id)).name(name).build();
    }
}
