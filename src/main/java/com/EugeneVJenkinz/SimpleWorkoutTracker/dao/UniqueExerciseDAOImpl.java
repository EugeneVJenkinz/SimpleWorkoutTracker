package com.EugeneVJenkinz.SimpleWorkoutTracker.dao;

import com.EugeneVJenkinz.SimpleWorkoutTracker.entity.UniqueExercise;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
@Scope("prototype")
public class UniqueExerciseDAOImpl implements UniqueExerciseDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void saveUniqueExercise(UniqueExercise uniqueExercise) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(uniqueExercise);
    }

    @Override
    @Transactional
    public UniqueExercise getUniqueExercise(UUID uniqueExerciseId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(UniqueExercise.class, uniqueExerciseId);
    }
}
