package com.EugeneVJenkinz.SimpleWorkoutTracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "exercises")
public class Exercise {
    @Id
    @Column(name = "exercise_id")
    private String exerciseId;
    @Column(name = "name")
    private String name;

    public Exercise() {
    }

    public String getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(String exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
