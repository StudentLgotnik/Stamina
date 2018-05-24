package com.project.spring.service;

import com.project.spring.model.User;
import java.util.List;

public interface UserService {

    public void addUser(User user);

    public void updateUser(User user);

    public void removeUser(int id);

    public User getUserById(int id);

    public User getByNameAndPass(String name, String password);

    public List<User> listUsers();

    public User getCurrent();

}
