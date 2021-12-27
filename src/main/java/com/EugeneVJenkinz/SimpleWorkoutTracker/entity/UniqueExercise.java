package com.EugeneVJenkinz.SimpleWorkoutTracker.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "unique_exercises")
public class UniqueExercise {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID unique_exercise_id;
    @Column(name = "exercise_name")
    private String exercise_name;
    @Column(name = "approach_number")
    private int approach_number;
    @Column(name = "weight")
    private int weight;
    @Column(name = "repeats")
    private Integer repeats;
    @Column(name = "relax_time")
    private Integer relax_time;
    @ManyToOne
    @JoinColumn(name="unique_training_id")
    UniqueTraining uniqueTraining;

    public UniqueExercise() {
    }

    public String getExercise_name() {
        return exercise_name;
    }

    public void setExercise_name(String exercise_name) {
        this.exercise_name = exercise_name;
    }

    public int getApproach_number() {
        return approach_number;
    }

    public void setApproach_number(int approach_number) {
        this.approach_number = approach_number;
    }

    public UUID getUnique_exercise_id() {
        return unique_exercise_id;
    }

    public void setUnique_exercise_id(UUID uniqueExerciseId) {
        this.unique_exercise_id = uniqueExerciseId;
    }

    public Integer getRepeats() {
        return repeats;
    }

    public void setRepeats(Integer repeats) {
        this.repeats = repeats;
    }

    public Integer getRelax_time() {
        return relax_time;
    }

    public void setRelax_time(Integer relaxTime) {
        this.relax_time = relaxTime;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public UniqueTraining getUniqueTraining() {
        return uniqueTraining;
    }

    public void setUniqueTraining(UniqueTraining uniqueTraining) {
        this.uniqueTraining = uniqueTraining;
    }
}
