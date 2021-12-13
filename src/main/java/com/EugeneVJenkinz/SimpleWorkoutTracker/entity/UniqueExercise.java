package com.EugeneVJenkinz.SimpleWorkoutTracker.entity;

import javax.persistence.*;

@Entity
@Table(name = "unique_exercises")
public class UniqueExercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unique_exercise_id")
    private String uniqueExerciseId;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;
    @Column(name = "repeats")
    private int repeats;
    @Column(name = "relax_time")
    private int relaxTime;

    public UniqueExercise() {
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public String getUniqueExerciseId() {
        return uniqueExerciseId;
    }

    public void setUniqueExerciseId(String uniqueExerciseId) {
        this.uniqueExerciseId = uniqueExerciseId;
    }

    public int getRepeats() {
        return repeats;
    }

    public void setRepeats(int repeats) {
        this.repeats = repeats;
    }

    public int getRelaxTime() {
        return relaxTime;
    }

    public void setRelaxTime(int relaxTime) {
        this.relaxTime = relaxTime;
    }
}
