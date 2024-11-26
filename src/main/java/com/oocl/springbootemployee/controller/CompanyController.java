package com.oocl.springbootemployee.controller;

import com.oocl.springbootemployee.model.Company;
import com.oocl.springbootemployee.model.Employee;
import com.oocl.springbootemployee.repository.CompanyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    // GET #obtain company list with response of id, name
    @GetMapping
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    // GET #obtain a certain specific company with response of id, name
    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable int id) {
        return companyRepository.findById(id);
    }

    // GET #obtain list of all employee under a certain specific company
    @GetMapping("/{id}/employees")
    public List<Employee> getEmployeesByCompanyId(@PathVariable int id) {
        return companyRepository.findEmployeesByCompanyId(id);
    }

    // GET #Page query
    @GetMapping("/page")
    public List<Company> getCompaniesByPage(@RequestParam int page, @RequestParam int size) {
        return companyRepository.findByPage(page, size);
    }

    // PUT #update an employee with company
    @PutMapping("/{companyId}/employees/{employeeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEmployeeWithCompany(@PathVariable int companyId, @PathVariable int employeeId) {
        companyRepository.updateEmployeeCompany(employeeId, companyId);
    }

    // POST #add a company
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Company addCompany(@RequestBody Company company) {
        return companyRepository.addCompany(company);
    }

    // DELETE #delete a company
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompany(@PathVariable int id) {
        companyRepository.deleteCompany(id);
    }
}
