package com.oocl.springbootemployee.repository;

import com.oocl.springbootemployee.model.Company;
import com.oocl.springbootemployee.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CompanyRepository {
    private final List<Company> companies = new ArrayList<>();
    private final List<Employee> employees = new ArrayList<>();

    public CompanyRepository() {
        companies.add(new Company(1, "OOCL1"));
        companies.add(new Company(2, "OOCL2"));
        companies.add(new Company(3, "OOCL3"));
    }

    public List<Company> findAll() {
        return new ArrayList<>(companies);
    }

    public Company findById(int id) {
        return companies.stream()
                .filter(company -> company.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Employee> findEmployeesByCompanyId(int companyId) {
        return employees.stream()
                .filter(employee -> employee.getCompanyId() == companyId)
                .collect(Collectors.toList());
    }

    public List<Company> findByPage(int page, int size) {
        int startIndex = (page - 1) * size;
        int endIndex = Math.min(startIndex + size, companies.size());
        return companies.subList(startIndex, endIndex);
    }

    public void updateEmployeeCompany(int employeeId, int companyId) {
        employees.stream()
                .filter(employee -> employee.getId() == employeeId)
                .findFirst()
                .ifPresent(employee -> employee.setCompanyId(companyId));
    }

    public Company addCompany(Company company) {
        companies.add(company);
        return company;
    }

    public void deleteCompany(int id) {
        companies.removeIf(company -> company.getId() == id);
    }
}
