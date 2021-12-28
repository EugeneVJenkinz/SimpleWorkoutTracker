package com.EugeneVJenkinz.SimpleWorkoutTracker.dao;

import com.EugeneVJenkinz.SimpleWorkoutTracker.entity.UniqueExercise;

import java.util.UUID;

public interface UniqueExerciseDAO {
    void saveUniqueExercise(UniqueExercise uniqueExercise);
    UniqueExercise getUniqueExercise(UUID uniqueExercise);
}
