package com.example.hotelmanagement;

public class Room {
    private int roomNumber;
    private String roomType;
    private double price;
    private boolean availability;

    public Room(int roomNumber, String roomType, double price, boolean availability) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.availability = availability;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
