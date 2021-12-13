package com.EugeneVJenkinz.SimpleWorkoutTracker.dao;

import com.EugeneVJenkinz.SimpleWorkoutTracker.entity.UniqueTraining;

public interface UniqueTrainingDAO {
    void saveUniqueTraining(UniqueTraining uniqueTraining);
    UniqueTraining getUniqueTraining(String uniqueTraining);
    void deleteUniqueTraining(String uniqueTraining);
}
