package com.project.spring.dao;

import com.project.spring.model.Type;
import com.project.spring.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TypeDaoImpl implements TypeDao{

    private static final Logger logger = LoggerFactory.getLogger(TypeDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addType(Type type) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(type);
        logger.info("Type succesfully saved. Type details: " + type);
    }

    @Override
    public void updateType(Type type) {
        Session sesion = this.sessionFactory.getCurrentSession();
        sesion.update(type);
        logger.info("Type succesfully updated. Type details: " + type);
    }

    @Override
    public Type getTypeById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Type type = (Type) session.load(Type.class, id);
        logger.info("Type succesfully loaded. Type details: " + type);
        return type;
    }

    @Override
    public List<Type> listTypes()
    {
        Session session = this.sessionFactory.getCurrentSession();
        List<Type> typeList = session.createQuery("from Type").list();
        for (Type u : typeList){
            logger.info("User list " + u);
        }
        return typeList;
    }

    @Override
    public List<Type> listUserTypes(int userId) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Type> typeList = session.createQuery("from Type T WHERE T.USERID = " + userId).list();
        for (Type u : typeList){
            logger.info("User list " + u);
        }
        return typeList;
    }

}
