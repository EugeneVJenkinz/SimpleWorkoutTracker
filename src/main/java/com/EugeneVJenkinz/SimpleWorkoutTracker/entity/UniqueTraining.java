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
    @OneToMany(mappedBy = "uniqueTraining",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<UniqueExercise> uniqueExerciseList;
    @Column(name = "training_date")
    private String date;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public UniqueTraining() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<UniqueExercise> getUniqueExerciseList() {
        return uniqueExerciseList;
    }

    public void setUniqueExerciseList(List<UniqueExercise> uniqueExerciseList) {
        this.uniqueExerciseList = uniqueExerciseList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
