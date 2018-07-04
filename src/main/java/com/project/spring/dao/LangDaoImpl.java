package com.project.spring.dao;

import com.project.spring.model.Language;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LangDaoImpl implements LangDao {

    private static final Logger logger = LoggerFactory.getLogger(LangDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }



    @Override
    public String getLangText(String language) {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Language where language = :lang");
        query.setParameter("lang", language);
        List<Language> languages = query.list();
        return languages.get(0).getText();
    }
}
