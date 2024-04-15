package com.example.hotelmanagement;

public class Guest {
    private String name;
    private String aadharNumber;

    public Guest(String name, String aadharNumber) {
        this.name = name;
        this.aadharNumber = aadharNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }
}
