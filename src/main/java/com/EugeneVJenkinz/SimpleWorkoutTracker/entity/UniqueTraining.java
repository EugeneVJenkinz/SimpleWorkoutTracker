package com.EugeneVJenkinz.SimpleWorkoutTracker.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "unique_training")
public class UniqueTraining {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "unique_training_id", updatable = false, nullable = false)
    private UUID id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "unique_exercise_id")
    private List<UniqueExercise> uniqueExerciseList;
    @Column(name = "training_date")
    private String date;

    public UniqueTraining() {
    }

    public String getId() {
        return id.toString();
    }

    public List<UniqueExercise> getUniqueExerciseList() {
        return uniqueExerciseList;
    }

    public void setUniqueExerciseList(List<UniqueExercise> uniqueExerciseList) {
        this.uniqueExerciseList = uniqueExerciseList;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
