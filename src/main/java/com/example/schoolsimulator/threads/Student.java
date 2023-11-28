package com.example.schoolsimulator.threads;

import com.almasb.fxgl.entity.Entity;
import com.example.schoolsimulator.models.Classroom;
import com.example.schoolsimulator.monitors.Manager;
import com.example.schoolsimulator.models.Place;
import com.example.schoolsimulator.models.Seat;

public class Student implements Runnable {
    private final Entity entity;
    private final Place checker;
    private final Manager manager;
    private final Integer iterator;

    public Student(Entity entity, Place checker, Manager manager, Integer iterator) {
        this.entity = entity;
        this.checker = checker;
        this.manager = manager;
        this.iterator = iterator;
    }

    @Override
    public synchronized void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // se colaca en el checker
        entity.setPosition(checker.getX(), checker.getY());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // se va afuera del salon
        entity.setPosition(380, 200 + (iterator * 2));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Seat seat = manager.getSeatAvailable();

        // se va a su silla
        entity.setPosition(seat.getPlace().getX(), seat.getPlace().getY());
        manager.setCheckerPlaceAvailable(checker);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Classroom currentClassroom = manager.getClassroom(seat.getNumberOfClassroom());
        while (currentClassroom.getIsTeaching()) {
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // se libera el asiento
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        entity.setPosition(0, 0);
        manager.setSeatAvailable(seat);

        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        entity.setPosition(-100, -100);
    }
}
