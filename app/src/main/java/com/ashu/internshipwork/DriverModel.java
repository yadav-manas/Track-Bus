package com.ashu.internshipwork;

public class DriverModel {
    private String name;
    private String busNumber;
    private String driverId;
    private String password;

    public DriverModel() {}

    public DriverModel(String name, String busNumber, String driverId, String password) {
        this.name = name;
        this.busNumber = busNumber;
        this.driverId = driverId;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public String getDriverId() {
        return driverId;
    }

    public String getPassword() {
        return password;
    }
}
