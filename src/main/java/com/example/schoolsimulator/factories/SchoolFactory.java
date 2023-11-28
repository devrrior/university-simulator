package com.example.schoolsimulator.factories;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.example.schoolsimulator.types.SchoolEntityType;

public class SchoolFactory implements EntityFactory {
    @Spawns("student")
    public Entity newStudent(SpawnData data) {
        return FXGL.entityBuilder(data)
                .type(SchoolEntityType.STUDENT)
                .view("student.png")
                .build();
    }

    @Spawns("teacher")
    public Entity newTeacher(SpawnData data) {
        return FXGL.entityBuilder(data)
                .type(SchoolEntityType.TEACHER)
                .view("teacher.png")
                .build();
    }
}
