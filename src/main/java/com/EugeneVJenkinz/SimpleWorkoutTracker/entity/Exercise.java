package com.EugeneVJenkinz.SimpleWorkoutTracker.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "exercises")
public class Exercise {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID exercise_id;
    @Column(name = "name")
    private String name;

    public Exercise() {
    }

    public UUID getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(UUID exerciseId) {
        this.exercise_id = exerciseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
