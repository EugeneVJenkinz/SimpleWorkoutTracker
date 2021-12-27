package com.EugeneVJenkinz.SimpleWorkoutTracker.dao;

import com.EugeneVJenkinz.SimpleWorkoutTracker.entity.UniqueTraining;

import java.security.Principal;
import java.util.UUID;

public interface UniqueTrainingDAO {
    void saveUniqueTraining(UniqueTraining uniqueTraining);
    UniqueTraining getUniqueTraining(UUID uniqueTraining);
    void deleteUniqueTraining(String uniqueTraining);
}
