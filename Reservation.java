package com.example.hotelmanagement;

public class Reservation {
    private Room room;
    private Guest guest;
    private int duration;

    public Reservation(Room room, Guest guest, int duration) {
        this.room = room;
        this.guest = guest;
        this.duration = duration;
    }

    public Room getRoom() {
        return room;
    }

    public Guest getGuest() {
        return guest;
    }

    public int getDuration() {
        return duration;
    }
}
