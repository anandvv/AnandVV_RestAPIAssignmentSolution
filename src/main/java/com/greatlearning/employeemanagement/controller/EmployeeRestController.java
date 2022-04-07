package com.greatlearning.employeemanagement.controller;

import com.greatlearning.employeemanagement.entity.Employee;
import com.greatlearning.employeemanagement.entity.Role;
import com.greatlearning.employeemanagement.entity.User;
import com.greatlearning.employeemanagement.service.EmployeeService;
import com.greatlearning.employeemanagement.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        this.employeeService = theEmployeeService;
    }

    @PostMapping("/user")
    public User saveUser(@RequestBody User user){
        return employeeService.saveUser(user);
    }

    @PostMapping("/role")
    public Role saveRole(@RequestBody Role role){
        return employeeService.saveRole(role);
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> currentPrincipalName = authentication.getAuthorities();
        System.out.println(currentPrincipalName);

        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);

        if(null == theEmployee){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
         theEmployee.setId(0);

         employeeService.save(theEmployee);

         return theEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){
        employeeService.save(theEmployee);

        return theEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee tempEmployee = employeeService.findById(employeeId);

        if(null == tempEmployee){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Delete employee id - " + employeeId;
    }

    @GetMapping("/employees/search/{firstName}")
    public List<Employee> searchByFirstName(@PathVariable String firstName){
        return employeeService.searchByFirstName(firstName);
    }

    @GetMapping("/employees/sort")
    public List<Employee> sortByFirstName(@RequestParam(name = "order") String order){
        return employeeService.sortByFirstname(order);
    }

    @GetMapping("/user")
    public List<User> getUsers(){
        return employeeService.getUsers();
    }
}
