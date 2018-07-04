package com.project.spring.service;

import com.project.spring.model.Type;

import java.util.List;

public interface TypeService {

    public void addType(Type type);

    public void updateType(Type type);

    public Type getTypeById(int id);

    public List<Type> listTypes();

    public List<Type> listUserTypes(int userId);

}
