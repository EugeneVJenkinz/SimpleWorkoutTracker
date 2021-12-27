package com.EugeneVJenkinz.SimpleWorkoutTracker.dao;

import com.EugeneVJenkinz.SimpleWorkoutTracker.entity.UniqueTraining;
import com.EugeneVJenkinz.SimpleWorkoutTracker.entity.User;

public interface UserDAO {
    User getUserByStringId(String userId);
    User getUserByUsername(String username);
    void update(User user);
}
