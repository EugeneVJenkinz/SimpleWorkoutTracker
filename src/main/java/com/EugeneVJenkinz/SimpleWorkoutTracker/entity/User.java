package com.EugeneVJenkinz.SimpleWorkoutTracker.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "user_id", updatable = false, nullable = false)
    private UUID userId;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "unique_training")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "unique_training_id")
    private List<UniqueTraining> uniqueTrainingHistory;

    public User() {
    }

    public String getUserId() {
        return userId.toString();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UniqueTraining> getUniqueTrainingHistory() {
        return uniqueTrainingHistory;
    }

    public void setUniqueTrainingHistory(List<UniqueTraining> uniqueTrainingHistory) {
        this.uniqueTrainingHistory = uniqueTrainingHistory;
    }

    public void setOneUniqueTraining(UniqueTraining uniqueTraining) {
        if (uniqueTrainingHistory == null) uniqueTrainingHistory = new LinkedList<>();
        uniqueTrainingHistory.add(uniqueTraining);
    }
}
