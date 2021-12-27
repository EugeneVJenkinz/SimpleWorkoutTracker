package com.EugeneVJenkinz.SimpleWorkoutTracker.dao;

import com.EugeneVJenkinz.SimpleWorkoutTracker.entity.UniqueTraining;
import com.EugeneVJenkinz.SimpleWorkoutTracker.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
@Scope("prototype")
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public User getUserByStringId(String userId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, UUID.fromString(userId));
    }

    @Override
    @Transactional
    public User getUserByUsername(String username) {
        Session session = sessionFactory.getCurrentSession();
        Query queryForId = session.createQuery("SELECT user_id FROM User WHERE username=:username");
        queryForId.setParameter("username", username);

        UUID uuid = (UUID) queryForId.getSingleResult();
        return session.get(User.class, uuid);
    }

    @Override
    @Transactional
    public void update(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }
}
