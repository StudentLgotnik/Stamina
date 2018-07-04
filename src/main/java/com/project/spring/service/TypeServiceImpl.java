package com.project.spring.service;

import com.project.spring.dao.TypeDao;
import com.project.spring.dao.UserDao;
import com.project.spring.model.Type;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    private TypeDao typeDao;

    public void setTypeDao(TypeDao typeDao) {
        this.typeDao = typeDao;
    }

    @Override
    @Transactional
    public void addType(Type type) {
        this.typeDao.addType(type);
    }

    @Override
    @Transactional
    public void updateType(Type type) {
        this.typeDao.updateType(type);
    }

    @Override
    @Transactional
    public Type getTypeById(int id) {
        return this.typeDao.getTypeById(id);
    }

    @Override
    @Transactional
    public List<Type> listTypes() {
        return this.typeDao.listTypes();
    }

    @Override
    @Transactional
    public List<Type> listUserTypes(int userId) {
        return this.typeDao.listUserTypes(userId);
    }

}
