package com.example.schoolsimulator.threads;

import com.almasb.fxgl.entity.Entity;
import com.example.schoolsimulator.models.Classroom;
import com.example.schoolsimulator.models.Place;

public class Teacher implements Runnable {
    private final Entity entity;
    private final Classroom classroom;
    private Place originalPlace;

    public Teacher(Integer number, Classroom classroom, Entity entity) {
        this.classroom = classroom;
        this.entity = entity;

        switch (number) {
            case 1:
                this.originalPlace = new Place(460.0, 400.0);
                break;
            case 2:
                this.originalPlace = new Place(500.0, 400.0);
                break;
            case 3:
                this.originalPlace = new Place(540.0, 400.0);
                break;
        }
    }

    @Override
    public synchronized void run() {
        entity.setPosition(classroom.getTeacherPlace().getX(), classroom.getTeacherPlace().getY());

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        entity.setPosition(originalPlace.getX(), originalPlace.getY());

        classroom.setIsTeaching(false);
        classroom.setAreStudentsGoingOut(true);

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        classroom.setAreStudentsGoingOut(false);

    }
}
