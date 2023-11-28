package com.example.schoolsimulator.models;

public class Seat {
    private final Place place;
    private final Integer numberOfClassroom;

    public Seat(Place place, Integer numberOfClassroom) {
        this.place = place;
        this.numberOfClassroom = numberOfClassroom;
    }

    public synchronized Place getPlace() {
        return place;
    }

    public synchronized Integer getNumberOfClassroom() {
        return numberOfClassroom;
    }
}
