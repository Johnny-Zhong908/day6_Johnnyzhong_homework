package com.oocl.springbootemployee.model;

public class Company {
    private int id;

    private String name;
    public Company (int id,String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public String getName(){
        return name;
    }

}