package com.oocl.springbootemployee.dto;

public class UpdateEmployeeDto {
    private int age;
    private double salary;

    public UpdateEmployeeDto() {
    }

    public UpdateEmployeeDto(int age, double salary) {
        this.age = age;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

