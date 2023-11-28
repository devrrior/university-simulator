package com.example.schoolsimulator.controllers;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.example.schoolsimulator.factories.SchoolFactory;
import com.example.schoolsimulator.models.*;
import com.example.schoolsimulator.monitors.Manager;
import com.example.schoolsimulator.threads.Student;
import javafx.fxml.Initializable;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class SimulatorController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXGL.getGameWorld().addEntityFactory(new SchoolFactory());
        Entity tentity1 = FXGL.spawn("teacher", 460, 400);
        Entity tentity2 = FXGL.spawn("teacher", 500, 400);
        Entity tentity3 = FXGL.spawn("teacher", 540, 400);
        Classroom classroom1 = new Classroom(1);
        Classroom classroom2 = new Classroom(2);
        Classroom classroom3 = new Classroom(3);
        Manager manager = new Manager(classroom1, classroom2, classroom3, tentity1, tentity2, tentity3);


        for (int i = 0; i < 150; i++) {
            int finalI = i;
            double delay = 3 + Math.random() * 3;

            FXGL.getGameTimer().runOnceAfter(() -> {
                Place checker = manager.getCheckerPlaceAvailable();
                Entity entity = FXGL.spawn("student", 20, 200+ (finalI * 2));
                Student student = new Student(entity, checker, manager, finalI);

                new Thread(student).start();
            }, Duration.seconds(delay + finalI));

        }
    }
}
