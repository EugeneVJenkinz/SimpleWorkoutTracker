package com.EugeneVJenkinz.SimpleWorkoutTracker.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "unique_training")
public class UniqueTraining {
    @Id
    @Column(name = "unique_training_id")
    private String uniqueTrainingId;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "unique_exercise_id")
    private List<UniqueExercise> uniqueExerciseList;
    @Column(name = "date")
    private String date;

    public UniqueTraining() {
    }

    public String getUniqueTrainingId() {
        return uniqueTrainingId;
    }

    public void setUniqueTrainingId(String uniqueTrainingId) {
        this.uniqueTrainingId = uniqueTrainingId;
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
