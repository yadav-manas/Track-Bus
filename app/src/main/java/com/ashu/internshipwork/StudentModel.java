package com.ashu.internshipwork;

public class StudentModel {
    private String name;
    private String rollNo;
    private String password;
    private String busNumber;

    public StudentModel() {}

    public StudentModel(String name, String rollNo, String password, String busNumber) {
        this.name = name;
        this.rollNo = rollNo;
        this.password = password;
        this.busNumber = busNumber;
    }

    public String getName() {
        return name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public String getPassword() {
        return password;
    }

    public String getBusNumber() {
        return busNumber;
    }
}
