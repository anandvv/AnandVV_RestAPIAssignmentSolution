package com.greatlearning.employeemanagement.service;

import com.greatlearning.employeemanagement.entity.Employee;
import com.greatlearning.employeemanagement.entity.Role;
import com.greatlearning.employeemanagement.entity.User;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(int id);

    public void save(Employee employee);

    public void deleteById(int id);

    List<Employee> searchByFirstName(String firstName);

    List<Employee> sortByFirstname(String order);

    User saveUser(User user);

    Role saveRole(Role role);

    List<User> getUsers();
}
