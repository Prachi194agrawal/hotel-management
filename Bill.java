package com.example.hotelmanagement;

public class Bill {
    private double totalBill;

    public Bill(double totalBill) {
        this.totalBill = totalBill;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }
}
