package com.example.bustracker;

public class AttendanceModel {
    private String name;
    private String studentId;
    private boolean present;

    public AttendanceModel() {
    }

    public AttendanceModel(String name, String studentId, boolean present) {
        this.name = name;
        this.studentId = studentId;
        this.present = present;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean Present) {
        this.present = Present;
    }
}
