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
    private UUID user_id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private List<UniqueTraining> uniqueTrainingHistory;

    public User() {
    }

    public String getUserIdString() {
        return user_id.toString();
    }

    public UUID getUser_id() {
        return user_id;
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
        if (uniqueTrainingHistory.equals(null)) uniqueTrainingHistory = new LinkedList<>();
        uniqueTrainingHistory.add(uniqueTraining);
    }
}
