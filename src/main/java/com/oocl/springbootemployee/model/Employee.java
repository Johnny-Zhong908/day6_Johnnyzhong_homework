package com.oocl.springbootemployee.model;

public class Employee {

    private int id;

    private String name;

    private int age;

    private Gender gender;

    private double salary;
    private int companyid;

    public Employee(int id, String name, int age, Gender gender, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public double getSalary() {
        return salary;
    }

    public int getCompanyId() {return companyid;}

    public void setCompanyId(int companyId) {this.companyid = companyId;}
}
