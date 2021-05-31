package com.gmail.moroka.mrk.spring_rest_employee_app.dao;


import com.gmail.moroka.mrk.spring_rest_employee_app.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    EntityManager entityManager;

    @Override
    public Employee getEmployee(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        Query query = entityManager.createQuery("from Employee");
        List<Employee> empList = query.getResultList();
        return empList;
    }

    @Override
    public void deleteEmployee(int id) {
        Query query = entityManager.createQuery("DELETE FROM Employee WHERE id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }

    @Override
    public void saveEmployee(Employee employee) {
        Employee employeeWithId = entityManager.merge(employee);
        employee.setId(employeeWithId.getId());
    }

}
