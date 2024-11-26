package com.oocl.springbootemployee.repository;

import com.oocl.springbootemployee.model.Employee;
import com.oocl.springbootemployee.model.Gender;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {

    private List<Employee> employees = new ArrayList<>();

    public EmployeeRepository() {
        this.employees.add(new Employee(1, "Sam1", 20, Gender.Male, 2000));
        this.employees.add(new Employee(2, "Sam2", 20, Gender.Male, 2000));
        this.employees.add(new Employee(3, "Sam3", 20, Gender.Female, 2000));
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Employee getById(int id) {
        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .orElseThrow();
    }

    public List<Employee> getByGender(Gender gender) {
        return employees.stream()
                .filter(employee -> employee.getGender() == gender)
                .collect(Collectors.toList());
    }

    public Employee addEmployee(Employee employee) {
        employee.setId(employees.size() + 1);
        employees.add(employee);
        return employee;
    }

    public Employee updateEmployee(int id, int age, double salary) {
        Employee employeeToUpdate = getById(id);
        employeeToUpdate.setAge(age);
        employeeToUpdate.setSalary(salary);
        return employeeToUpdate;
    }
    public void deleteEmployeeById(int id) {
        employees.removeIf(employee -> employee.getId() == id);
    }
    public List<Employee> getEmployeesByPage(int page, int size) {
        int skipCount = (page - 1) * size;
        return employees.stream()
                .skip(skipCount)
                .limit(size)
                .collect(Collectors.toList());
    }


}
