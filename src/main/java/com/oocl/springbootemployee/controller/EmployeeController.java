package com.oocl.springbootemployee.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oocl.springbootemployee.dto.UpdateEmployeeDto;
import com.oocl.springbootemployee.model.Employee;
import com.oocl.springbootemployee.model.Gender;
import com.oocl.springbootemployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

//    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping()
    public List<Employee> getEmployees() {
        return employeeRepository.getEmployees();
    }

    @PostMapping(path = "/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeRepository.getById(id);
    }

    @GetMapping(params = "gender")
    public List<Employee> getEmployeesByGender(@RequestParam Gender gender) {
        return employeeRepository.getByGender(gender);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeRepository.addEmployee(employee);
    }

    @PutMapping(path = "/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody UpdateEmployeeDto updateEmployeeDto){
        return employeeRepository.updateEmployee(id, updateEmployeeDto.getAge(), updateEmployeeDto.getSalary());
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable int id) {
        employeeRepository.deleteEmployeeById(id);
    }
    @GetMapping(params = {"page", "size"})
    public List<Employee> getEmployeesByPage(@RequestParam int page, @RequestParam int size) {
        return employeeRepository.getEmployeesByPage(page, size);
    }


}
