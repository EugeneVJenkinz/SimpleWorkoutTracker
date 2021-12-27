package com.EugeneVJenkinz.SimpleWorkoutTracker.dao;

import com.EugeneVJenkinz.SimpleWorkoutTracker.entity.UniqueTraining;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.Date;
import java.util.UUID;

@Repository
@Scope("prototype")
public class UniqueTrainingDAOImpl implements UniqueTrainingDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public void saveUniqueTraining(UniqueTraining uniqueTraining) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(uniqueTraining);
    }

    @Override
    @Transactional
    public UniqueTraining getUniqueTraining(UUID uniqueTrainingId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(UniqueTraining.class, uniqueTrainingId);
    }

    @Override
    @Transactional
    public void deleteUniqueTraining(String uniqueTrainingId) {
        Session session = sessionFactory.getCurrentSession();
        Query query =  session.createQuery("DELETE FROM UniqueTraining WHERE uniqueTrainingId=:uniqueTrainingId");
        query.setParameter("uniqueTrainingId", uniqueTrainingId);
        query.executeUpdate();
    }
}