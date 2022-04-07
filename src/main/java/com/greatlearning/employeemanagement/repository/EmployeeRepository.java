package com.greatlearning.employeemanagement.repository;

import com.greatlearning.employeemanagement.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("SELECT e FROM Employee e WHERE lower(e.firstName) LIKE lower(?1)")
    List<Employee> findByFirstNameContainsAllIgnoreCase(String firstName);

    List<Employee> findAllByOrderByFirstNameAsc();

    List<Employee> findAllByOrderByFirstNameDesc();
}
