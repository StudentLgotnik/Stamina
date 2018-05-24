package com.project.spring.dao;

import com.project.spring.model.Type;
import com.project.spring.model.User;

import java.util.List;

public interface TypeDao {

    public void addType(Type type);

    public void updateType(Type type);

    public Type getTypeById(int id);

    public List<Type> listTypes();

    public List<Type> listUserTypes(int userId);

    public String getLangText(String language);

}
