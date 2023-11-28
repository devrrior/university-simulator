package com.example.schoolsimulator.monitors;

import com.almasb.fxgl.entity.Entity;
import com.example.schoolsimulator.models.Classroom;
import com.example.schoolsimulator.models.Place;
import com.example.schoolsimulator.models.Seat;
import com.example.schoolsimulator.threads.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private final List<Place> checkerPlaces;
    private final Classroom classroom1;
    private final Classroom classroom2;
    private final Classroom classroom3;
    private final Teacher teacher1;
    private final Teacher teacher2;
    private final Teacher teacher3;

    public Manager(Classroom classroom1, Classroom classroom2, Classroom classroom3, Entity teacher1, Entity teacher2, Entity teacher3) {
        this.classroom1 = classroom1;
        this.classroom2 = classroom2;
        this.classroom3 = classroom3;
        this.teacher1 = new Teacher(1, classroom1, teacher1);
        this.teacher2 = new Teacher(2, classroom2, teacher2);
        this.teacher3 = new Teacher(3, classroom3, teacher3);

        this.checkerPlaces = new ArrayList<>();

        checkerPlaces.add(new Place(5.0, 80.0));
        checkerPlaces.add(new Place(65.0, 80.0));
        checkerPlaces.add(new Place(125.0, 80.0));
        checkerPlaces.add(new Place(185.0, 80.0));
        checkerPlaces.add(new Place(245.0, 80.0));
    }

    public synchronized Place getCheckerPlaceAvailable() {
        while (true) {
            for (Place place : checkerPlaces) {
                if (place.getIsAvailable()) {
                    place.setIsAvailable(false);
                    return place;
                }
            }

            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void setCheckerPlaceAvailable(Place place) {
        place.setIsAvailable(true);
        this.notifyAll();
    }

    public synchronized Seat getSeatAvailable() {
        while (true) {
            if (classroom1.getCapacity() > 0 && !classroom1.getAreStudentsGoingOut()) {
                for (Place place : classroom1.getSeats()) {
                    if (place.getIsAvailable()) {
                        place.setIsAvailable(false);
                        classroom1.setCapacity(classroom1.getCapacity() - 1);

                        if (classroom1.getCapacity().equals(0)) {
                            new Thread(teacher1).start();
                        }

                        classroom1.setIsTeaching(true);
                        return new Seat(place, 1);
                    }
                }
            } else if (classroom2.getCapacity() > 0 && !classroom2.getAreStudentsGoingOut()) {
                for (Place place : classroom2.getSeats()) {
                    if (place.getIsAvailable()) {
                        place.setIsAvailable(false);
                        classroom2.setCapacity(classroom2.getCapacity() - 1);

                        if (classroom2.getCapacity().equals(0)) {
                            new Thread(teacher2).start();
                        }

                        classroom2.setIsTeaching(true);
                        return new Seat(place, 2);
                    }
                }
            } else if (classroom3.getCapacity() > 0 && !classroom3.getAreStudentsGoingOut()) {
                for (Place place : classroom3.getSeats()) {
                    if (place.getIsAvailable()) {
                        place.setIsAvailable(false);
                        classroom3.setCapacity(classroom3.getCapacity() - 1);

                        if (classroom3.getCapacity().equals(0)) {
                            new Thread(teacher3).start();
                        }

                        classroom3.setIsTeaching(true);
                        return new Seat(place, 3);
                    }
                }
            }

            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void setSeatAvailable(Seat seat) {
        seat.getPlace().setIsAvailable(true);

        if (seat.getNumberOfClassroom().equals(1)) {
            classroom1.setCapacity(classroom1.getCapacity() + 1);
        } else if (seat.getNumberOfClassroom().equals(2)) {
            classroom2.setCapacity(classroom2.getCapacity() + 1);
        } else if (seat.getNumberOfClassroom().equals(3)){
            classroom3.setCapacity(classroom3.getCapacity() + 1);
        }
        this.notifyAll();
    }

    public synchronized Classroom getClassroom(Integer number) {
        if (number.equals(1)) {
            return classroom1;
        } else if (number.equals(2)) {
            return classroom2;
        } else {
            return classroom3;
        }
    }
}
