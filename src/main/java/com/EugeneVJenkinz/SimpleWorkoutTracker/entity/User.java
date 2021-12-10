package com.EugeneVJenkinz.SimpleWorkoutTracker.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    private String userId;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "training_history")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "unique_training_id")
    private List<UniqueTraining> uniqueTrainingHistory;

    public User() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
}
