package com.EugeneVJenkinz.SimpleWorkoutTracker.dao;

import com.EugeneVJenkinz.SimpleWorkoutTracker.entity.Exercise;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Scope("prototype")
public class ExerciseDAOImpl implements ExerciseDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Exercise> getExerciseList() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Exercise", Exercise.class).list();
    }
}
