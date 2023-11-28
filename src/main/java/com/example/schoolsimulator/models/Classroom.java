package com.example.schoolsimulator.models;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private List<Place> seats;
    private Integer capacity;
    private Boolean isTeaching;
    private Integer numberOfStudentsInClass;
    private Place teacherPlace;
    private Boolean areStudentsGoingOut;

    public Classroom(Integer numberOfClass) {
        this.capacity = 9;
        this.isTeaching = false;
        this.areStudentsGoingOut = false;

        switch (numberOfClass) {
            case 1:
                this.seats = new ArrayList<>();

                this.seats.add(new Place(625.0, 50.0));
                this.seats.add(new Place(625.0, 70.0));
                this.seats.add(new Place(625.0, 90.0));

                this.seats.add(new Place(685.0, 50.0));
                this.seats.add(new Place(685.0, 70.0));
                this.seats.add(new Place(685.0, 90.0));

                this.seats.add(new Place(740.0, 50.0));
                this.seats.add(new Place(740.0, 70.0));
                this.seats.add(new Place(740.0, 90.0));

                this.teacherPlace = new Place(685.0, 20.0);
                break;

            case 2:
                this.seats = new ArrayList<>();

                this.seats.add(new Place(625.0, 200.0));
                this.seats.add(new Place(625.0, 220.0));
                this.seats.add(new Place(625.0, 240.0));

                this.seats.add(new Place(685.0, 200.0));
                this.seats.add(new Place(685.0, 220.0));
                this.seats.add(new Place(685.0, 240.0));

                this.seats.add(new Place(740.0, 200.0));
                this.seats.add(new Place(740.0, 220.0));
                this.seats.add(new Place(740.0, 240.0));

                this.teacherPlace = new Place(685.0, 180.0);
                break;

            case 3:
                this.seats = new ArrayList<>();

                this.seats.add(new Place(625.0, 350.0));
                this.seats.add(new Place(625.0, 370.0));
                this.seats.add(new Place(625.0, 390.0));

                this.seats.add(new Place(685.0, 350.0));
                this.seats.add(new Place(685.0, 370.0));
                this.seats.add(new Place(685.0, 390.0));

                this.seats.add(new Place(740.0, 350.0));
                this.seats.add(new Place(740.0, 370.0));
                this.seats.add(new Place(740.0, 390.0));

                this.teacherPlace = new Place(685.0, 330.0);
                break;

        }
    }

    public List<Place> getSeats() {
        return seats;
    }

    public synchronized Integer getCapacity() {
        return capacity;
    }

    public synchronized void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public synchronized Boolean getIsTeaching() {
        return isTeaching;
    }

    public synchronized void setIsTeaching(Boolean teaching) {
        isTeaching = teaching;
    }

    public synchronized Integer getNumberOfStudentsInClass() {
        return numberOfStudentsInClass;
    }

    public synchronized void setNumberOfStudentsInClass(Integer numberOfStudentsInClass) {
        this.numberOfStudentsInClass = numberOfStudentsInClass;
    }

    public synchronized Place getTeacherPlace() {
        return teacherPlace;
    }

    public synchronized void setTeacherPlace(Place teacherPlace) {
        this.teacherPlace = teacherPlace;
    }

    public synchronized Boolean getAreStudentsGoingOut() {
        return areStudentsGoingOut;
    }

    public synchronized void setAreStudentsGoingOut(Boolean areStudentsGoingOut) {
        this.areStudentsGoingOut = areStudentsGoingOut;
    }
}
