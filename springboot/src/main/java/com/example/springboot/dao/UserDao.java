package com.example.springboot.dao;



import com.example.springboot.model.User;

import java.util.List;

public interface UserDao {
    User getUser(long id);
    List<User> listUsers();
    void addUser(User user);
    void editUser(User user);
    void removeUser(long id);
}
