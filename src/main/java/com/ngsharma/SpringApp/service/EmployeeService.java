package com.ngsharma.SpringApp.service;

import com.ngsharma.SpringApp.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee> findAll();
    Optional<Employee> findById(Integer id);
    Employee save(Employee emp);
    void deleteById(Integer id);
    void deleteEntity(Employee emp);
}
