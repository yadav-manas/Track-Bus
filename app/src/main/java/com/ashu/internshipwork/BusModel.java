package com.ashu.internshipwork;

public class BusModel {
    private String busNo;
    private String route;
    private int capacity;

    // Default constructor
    public BusModel() {}

    // Parameterized constructor
    public BusModel(String busNo, String route, int capacity) {
        this.busNo = busNo;
        this.route = route;
        this.capacity = capacity;
    }

    // Getter for bus number
    public String getBusNo() {
        return busNo;
    }

    // Getter for route
    public String getRoute() {
        return route;
    }

    // Getter for capacity
    public int getCapacity() {
        return capacity;
    }

    // Optional: Setter methods if needed
    public void setBusNo(String busNo) {
        this.busNo = busNo;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
