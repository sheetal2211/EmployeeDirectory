package org.employee;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.employee.model.Employee;
import org.employee.model.Employees;
import org.employee.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RolesResource implements RolesApi {

    @Override
    public ResponseEntity<List<Role>> listRoles() {
        Role role = new Role(1L, "Software Developer");
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }
}
