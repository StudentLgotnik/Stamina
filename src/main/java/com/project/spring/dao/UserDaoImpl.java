package com.project.spring.dao;

import com.project.spring.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        logger.info("User succesfully saved. User details: " + user);
    }

    @Override
    public void updateUser(User user) {
        Session sesion = this.sessionFactory.getCurrentSession();
        sesion.update(user);
        logger.info("User succesfully updated. User details: " + user);
    }

    @Override
    public void removeUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, id);
        if (user != null){
            session.delete(user);
        }
        logger.info("User succesfully deleted. User details: " + user);
    }

    @Override
    public User getUserById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, id);
        logger.info("User succesfully loaded. User details: " + user);
        return user;
    }

    @Override
    public User getByNameAndPass(String name, String password) {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(User.class);
        User user = (User) criteria.add(Restrictions.eq("name", name))
                .add(Restrictions.eq("password", password))
                .uniqueResult();
        return user;
    }


    @Override
    public List<User> listUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User").list();
        for (User u : userList){
            logger.info("User list " + u);
        }
        return userList;
    }

    @Override
    public User getCurrent() {
        User current = null;
        for (User u : listUsers()){
            if (u.getCurrent()) current = u;
        }
        return current;
    }

}
