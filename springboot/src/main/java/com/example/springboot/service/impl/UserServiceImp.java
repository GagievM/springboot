package com.example.springboot.service.impl;

import com.example.springboot.dao.UserDao;
import com.example.springboot.model.User;
import com.example.springboot.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private UserDao userDao;
    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUser(long id) {
        return userDao.getUser(id);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
    @Transactional
    @Override
    public void editUser(User user) {
        userDao.editUser(user);
    }
    @Transactional
    @Override
    public void removeUser(long id) {
        userDao.removeUser(id);
    }
}
