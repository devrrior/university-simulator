package com.example.schoolsimulator.models;

public class Place {
    private final Double x;
    private final Double y;
    private Boolean isAvailable;

    public Place(Double x, Double y) {
        this.x = x;
        this.y = y;
        this.isAvailable = true;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public synchronized Boolean getIsAvailable() {
        return isAvailable;
    }

    public synchronized void setIsAvailable(Boolean available) {
            isAvailable = available;
    }
}
