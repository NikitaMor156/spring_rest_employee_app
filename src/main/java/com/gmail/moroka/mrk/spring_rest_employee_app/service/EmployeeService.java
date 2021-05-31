package com.gmail.moroka.mrk.spring_rest_employee_app.service;

import com.gmail.moroka.mrk.spring_rest_employee_app.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee getEmployee(int id);

    public List<Employee> getAllEmployees();

    public void deleteEmployee(int id);

    public void saveEmployee(Employee employee);


}
