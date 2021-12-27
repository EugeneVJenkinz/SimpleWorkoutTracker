package com.EugeneVJenkinz.SimpleWorkoutTracker.dao;

import com.EugeneVJenkinz.SimpleWorkoutTracker.entity.Exercise;

import java.util.List;

public interface ExerciseDAO {
    List<Exercise> getExerciseList();
}
