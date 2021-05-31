package com.gmail.moroka.mrk.spring_rest_employee_app.controller;


import com.gmail.moroka.mrk.spring_rest_employee_app.entity.Employee;
import com.gmail.moroka.mrk.spring_rest_employee_app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/employees") // Get all employee objects from DB
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/test") // Creates a "test" object of class Employee and puts it into DB
    public void addTestEmployee(HttpServletResponse response) throws IOException {
        Employee employee = new Employee("TestName", "TestSurname", "test@testmail.com");
        employeeService.saveEmployee(employee);
        response.sendRedirect("/");
    }

    @PostMapping("/employees") // If id of employee object is not specified than creates a new object in DB
    //                               If not - updates existing object in DB
    public void saveEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
    }

    @GetMapping("/employees/{id}") // Get employee obj by id parameter
    public Employee getEmployee(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

    @DeleteMapping("/employees/{id}") // Delete employee obj from DB by id parameter
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }


}
