package com.example.javafxproject;
//package application;
public class employee {
    private int id;
    private String fname;
    private String lname;
    private String gender;
    private String position;
    private String phoneNb;
    private int salary;


    public employee(int Empid,String fname,String lname,String gender,String phoneNb,String position) {
        this.id=Empid;
        this.fname=fname;
        this.lname=lname;
        this.gender=gender;
        this.phoneNb=phoneNb;
        this.position=position;

    }
    public employee(int EmployeeId,String fname,String lname,String position,int salary) {
        this.id=EmployeeId;
        this.fname=fname;
        this.lname=lname;
        this.position=position;
        this.salary=salary;

    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return this.fname;
    }
    public String getLname() {
        return this.lname;
    }
    public String getGender(){
        return gender;
    }
    public String getPhoneNb(){
        return this.phoneNb;
    }
    public String getPosition(){
        return this.position;
    }
    public int getSalary(){
        return this.salary;
    }

}
